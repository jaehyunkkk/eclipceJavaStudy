package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class L19StreamAPIEx5 {
	
	class Student{
		private String name;
		private boolean isMale;
		private int hak;
		private int ban;
		private int score;
		public Student(String name,boolean isMale,int hak,int ban,int score) {
			this.name=name;
			this.isMale=isMale;
			this.hak=hak;
			this.ban=ban;
			this.score=score;
		}
		public String getName() {return name;}
		public boolean isMale() {return isMale;}
		public int getHak() {return hak;}
		public int getBan() {return ban;}
		public int getScore() {return score;}
		
		
		@Override
		public String toString() {
			return "{"+name +","+isMale+","+hak+","+ban+","+ score+"}";
		}
	}

	public static void main(String[] args) {

		List<Student> studentList=new ArrayList<Student>();
		L19StreamAPIEx5 out=new L19StreamAPIEx5();
		studentList.add(out.new Student("나자바", true, 1, 1, 300));
		studentList.add(out.new Student("김지미", false, 1, 1, 250));
		studentList.add(out.new Student("김자바", true, 1, 1, 200));
		studentList.add(out.new Student("이지미", false, 1, 2, 150));
		studentList.add(out.new Student("남자바", true, 1, 2, 100));
		studentList.add(out.new Student("안지미", false, 1, 2, 50));
		studentList.add(out.new Student("황지미", false, 1, 3, 100));
		studentList.add(out.new Student("강지미", false, 1, 3, 150));

		studentList.add(out.new Student("나자바", true, 2, 1, 300));
		studentList.add(out.new Student("김지미", false, 2, 1, 250));
		studentList.add(out.new Student("김자바", true, 2, 1, 200));
		studentList.add(out.new Student("이지미", false, 2, 2, 150));
		studentList.add(out.new Student("남자바", true, 2, 2, 100));
		studentList.add(out.new Student("안지미", false, 2, 2, 50));
		studentList.add(out.new Student("황지미", false, 2, 3, 100));
		studentList.add(out.new Student("강지미", false, 2, 3, 150));

		studentList.add(out.new Student("나자바", true, 3, 1, 300));
		studentList.add(out.new Student("김지미", false, 3, 1, 250));
		studentList.add(out.new Student("김자바", true, 3, 1, 200));
		studentList.add(out.new Student("이지미", false, 3, 2, 150));
		studentList.add(out.new Student("남자바", true, 3, 2, 100));
		studentList.add(out.new Student("안지미", false, 3, 2, 50));
		studentList.add(out.new Student("황지미", false, 3, 3, 100));
		studentList.add(out.new Student("강지미", false, 3, 3, 150));



		//1학년 남자들의 점수
		studentList.stream()
			.filter((s)->s.hak == 1)
			.filter((s)->s.isMale == true)
			.map((s)->s.score)
			.forEach((s)->System.out.print(s+" "));
		
		System.out.println();
		System.out.println();
		
		//2학년 여자들의 점수
		studentList.stream()
			.filter((s)->s.hak == 2)
			.filter((s)->s.isMale == false)
			.map((s)->s.score)
			.forEach((s)->System.out.print(s+" "));
	
		System.out.println();
		System.out.println();
	
		//1한년의 남자 여자의 수를 collect로 구현하세요!
		Long maleCnt = studentList.stream()
			.filter((s)->s.hak == 1)
			.filter((s)->s.isMale == true)
			.collect(Collectors.counting());
		Long femaleCnt = studentList.stream()
			.filter((s)->s.hak == 1)
			.filter((s)->s.isMale == false)
			.collect(Collectors.counting());
		System.out.println(maleCnt + " " + femaleCnt);
		
		System.out.println();
		
		//1한년을 남자 여자의 그룹으로 나누고 다시 통과(score>=150)와 낙제 그룹으로 나누세요. //partitioningBy 사용
		Map<Boolean, List<Student>> groupingList = studentList.stream()
			.collect(Collectors.partitioningBy(Student::isMale));
		Map<Boolean, List<Student>> malePass = groupingList.get(true).stream()
			.collect(Collectors.partitioningBy((s)->s.getScore() >= 150));
		System.out.println(malePass);
		Map<Boolean, List<Student>> femalePass = groupingList.get(false).stream()
			.collect(Collectors.partitioningBy((s)->s.getScore() >= 150));
		System.out.println(femalePass);
			
		System.out.println();
		
		//1학년 남자,여자 그룹의 평균 점수를 구하세요
		Map<Boolean, List<Student>> groupingList2 = studentList.stream()
			.filter((s)->s.getHak() == 1)
			.collect(Collectors.partitioningBy(Student::isMale));
		Double maleAvg = groupingList2.get(true).stream()
			.collect(Collectors.averagingDouble((s)->s.getScore()));
		System.out.println(maleAvg);
		Double femaleAvg = groupingList2.get(false).stream()
			.collect(Collectors.averagingDouble((s)->s.getScore()));
		System.out.println(femaleAvg);
		
		//각학년별 남자 여자 그룹의  접수가 가장 높은 사람을 구하세요 //집계함수 사용
		final Comparator<Student> comp1 = (s1, s2) -> Integer.valueOf(s1.getScore()).compareTo(Integer.valueOf(s2.getScore()));
		
		Map<Integer,List<Student>> hakGroup = studentList.stream()
			.collect(Collectors.groupingBy(s->s.getHak()));
		
		Map<Boolean, List<Student>> maleGroup = hakGroup.get(1).stream()
			.collect(Collectors.groupingBy(s->s.isMale));
		Optional<Student> mmax = maleGroup.get(true).stream()
			.max(comp1);
		System.out.print(mmax);
		mmax = maleGroup.get(false).stream()
			.max(comp1);
		System.out.print(mmax);
		
		maleGroup = hakGroup.get(2).stream()
			.collect(Collectors.groupingBy(s->s.isMale));
		mmax = maleGroup.get(true).stream()
			.max(comp1);
		System.out.print(mmax);
		mmax = maleGroup.get(false).stream()
			.max(comp1);
		System.out.print(mmax);
		
		maleGroup = hakGroup.get(3).stream()
			.collect(Collectors.groupingBy(s->s.isMale));
		mmax = maleGroup.get(true).stream()
			.max(comp1);
		System.out.print(mmax);
		mmax = maleGroup.get(false).stream()
			.max(comp1);
		System.out.print(mmax);
		
		System.out.println();
		System.out.println();
		
		//2한년을 남자 여자의 그룹으로 나누고 다시 통과한 사람과 낙제 한 사람의 수를 구하세요
		maleGroup = hakGroup.get(2).stream()
			.collect(Collectors.groupingBy(s->s.isMale));
		
		Map<Boolean, List<Student>> passFail = maleGroup.get(true).stream()
			.collect(Collectors.partitioningBy(s->s.getScore() >= 150));
		System.out.println(passFail);
		passFail = maleGroup.get(false).stream()
			.collect(Collectors.partitioningBy(s->s.getScore() >= 150));
		System.out.println(passFail);
		System.out.println();
		
		//모든 학년을 그룹으로 나누고 학년 마다  남자와 여자 그룹의 수를 구하세요
		long cnt = hakGroup.get(1).stream()
			.collect(Collectors.partitioningBy(s->s.isMale))
			.get(true).stream()
			.count();
		System.out.print(cnt + " ");
		cnt = hakGroup.get(1).stream()
				.collect(Collectors.partitioningBy(s->s.isMale))
				.get(false).stream()
				.count();
		System.out.println(cnt);
		
		cnt = hakGroup.get(2).stream()
				.collect(Collectors.partitioningBy(s->s.isMale))
				.get(true).stream()
				.count();
		System.out.print(cnt + " ");
		cnt = hakGroup.get(2).stream()
				.collect(Collectors.partitioningBy(s->s.isMale))
				.get(false).stream()
				.count();
		System.out.println(cnt);
			
		cnt = hakGroup.get(3).stream()
				.collect(Collectors.partitioningBy(s->s.isMale))
				.get(true).stream()
				.count();
		System.out.print(cnt + " ");
		cnt = hakGroup.get(3).stream()
				.collect(Collectors.partitioningBy(s->s.isMale))
				.get(false).stream()
				.count();
		System.out.println(cnt);
		
		System.out.println();
		
		//모든 학년을 그룹으로 나누고 학년 마다  반 그룹으로 나누세요
		Map<Integer, List<Student>> banGroup = hakGroup.get(1).stream()
				.collect(Collectors.groupingBy(s->s.getBan()));
		System.out.println(banGroup);
		
		banGroup = hakGroup.get(2).stream()
				.collect(Collectors.groupingBy(s->s.getBan()));
		System.out.println(banGroup);
		
		banGroup = hakGroup.get(3).stream()
				.collect(Collectors.groupingBy(s->s.getBan()));
		System.out.println(banGroup);
		

	}
}
