package pl.edu.wat.model;

public class PolicemanRank {
	public enum Rank{
		posterunkowy(1),
		starszy_posterunkowy(2),
		sierżant(3),
		starszy_sierżant(4),
		aspirant(5),
		podkomisarz(6),
		komisarz(7),
		nadkomisarz(8),
		podinspektor(9),
		inspektor(10),
		nadinspektor(11),
		generalny_inspektor(12);
		
		int RankID;
		
		private Rank(int i){
			RankID=i;
		}
	}
}
