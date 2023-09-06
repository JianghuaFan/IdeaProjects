package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortLaiCode {
	//第三遍
	public int[] quickSort(int[] array) {
	
	//1.Find a pivot, which satisfies that all the elements to the left of pivot are smaller or equal to pivot,
		// all the elements to the right of pivot are greater than the pivot
	// 2.  Divide the array to two parts with the pivot.
		if (array == null || array.length == 1)
			return array;
		int left = 0;
		int right = array.length - 1;
		quickSort(array, left, right);
		return array;
	}
	 
	private void quickSort(int[] array, int left, int right) {
		if ( left >= right)
			return;
		int pivot = partition(array, left, right);
		quickSort(array, left, pivot - 1);
		quickSort(array, pivot + 1, right);
	}
	
		private int partition(int[] array, int left, int right){
		  int pivotIndex = pivotIndex(left, right);
	      int pivot = array[pivotIndex];
		  swap(array, pivotIndex, right);

		  int leftBound = left;
		  int rightBound = right - 1;

		  while(leftBound <= rightBound) {
		    if(array[leftBound] <= pivot){
		    	leftBound++;
		    }
		    else if (array[rightBound] > pivot ) {
		    	rightBound--;
		    }
		    else 
		    	swap(array, leftBound++, rightBound--);			    	
		  }
		  swap(array, leftBound, right);
		  return leftBound;
		}		
		 
	  private static int pivotIndex(int left, int right) {
//		  Random rand = new Random();
//		  int pivot = rand.nextInt(right - left + 1) + left;
		  int pivot = (int)Math.random()*(right - left + 1) + left;
		  return pivot;
		} 
		private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortLaiCode quickSort = new QuickSortLaiCode();
		
		int[] array = {2,5,1,4,3};
//		int[] array = new int[]{355,177,448,-286,375,-190,391,-205,180,-460,355,-118,305,-363,23,478,79,234,180,264,400,-172,297,-324,378,368,500,204,32,-362,133,-33,394,97,338,-249,225,450,206,-458,136,21,199,-429,189,419,79,3,8,85,119,-272,140,59,326,136,262,-308,347,366,451,118,82,316,500,-17,399,-446,263,320,73,426,222,496,366,-184,353,-198,312,445,485,-344,445,124,146,330,265,84,400,-197,345,349,401,-365,417,141,292,-277,285,477,216,434,297,438,2,-128,465,67,142,-18,150,-492,398,-224,3,-239,283,231,43,420,336,284,462,-170,429,-69,361,379,374,-346,193,58,366,247,234,5,235,-327,391,454,127,-258,80,434,88,261,330,-419,102,-216,72,-370,358,270,420,-480,22,-272,462,-443,423,443,310,-275,467,448,312,108,129,-271,423,305,178,51,329,-73,249,411,405,490,74,-148,83,-472,60,-229,111,311,489,-48,75,350,410,217,380,-243,295,-9,179,-358,210,119,452,-77,174,-92,163,330,464,-226,34,-61,447,-199,83,246,26,236,134,-330,480,206,485,378,441,-59,398,487,315,384,472,36,321,366,324,-397,320,450,319,56,353,143,356,-239,229,415,441,471,140,372,457,285,121,492,144,263,223,53,428,-234,480,224,219,110,249,-122,325,-101,106,290,57,259,360,-184,473,250,295,52,98,-62,25,210,204,-39,284,188,39,-75,159,335,51,-333,146,-16,356,194,469,-361,273,152,380,125,335,-236,150,97,209,498,121,58,399,165,105,423,70,-236,470,268,178,138,62,54,427,445,123,47,379,492,21,153,247,254,51,-424,119,244,145,56,487,-25,141,425,54,444,286,-105,357,418,325,-221,213,329,1,333,496,-257,342,-5,110,-305,7,-364,437,-328,415,295,305,-356,176,-472,340,362,234,-293,225,81,270,-466,134,-49,284,-437,174,-368,264,-217,291,52,152,143,100,-153,214,459,116,-282,106,307,275,-140,264,371,39,-363,323,179,230,-116,493,345,30,-412,326,228,339,188,455,386,385,419,240,326,145,455,365,-163,246,67,174,-388,75,-332,23,-27,352,404,118,245,382,-96,181,-257,144,-100,372,377,223,-302,206,-378,460,402,174,-64,439,-141,490,-222,196,-467,289,34,217,-105,192,2,422,479,468,104,448,422,42,122,81,194,294,79,194,224,26,-150,500,282,78,205,341,-157,423,268,98,82,60,315,110,-150,287,414,278,-278,343,-342,230,189,72,-326,116,167,57,-409,212,241,260,-63,107,-480,425,-255,276,498,432,-282,319,109,496,472,110,0,383,-293,460,120,447,-325,278,-82,494,453,483,-208,478,335,200,-60,190,140,453,462,455,333,252,341,462,-343,61,-43,76,388,199,-104,21,427,283,119,447,198,225,19,317,-306,286,470,123,117,27,-224,244,231,338,300,227,-56,14,-327,7,-331,88,-316,452,-338,292,350,231,-78,211,210,332,209,241,-411,25,383,35,425,316,-393,131,275,345,-118,393,280,281,43,310,199,117,-407,75,88,278,-288,158,-138,193,346,369,-242,395,-464,125,-344,384,69,313,346,278,57,256,81,376,296,394,160,441,114,287,-111,11,-43,82,-26,161,119,481,298,14,-86,171,89,344,19,10,-339,382,-65,58,285,393,276,317,260,269,78,208,-85,229,454,22,94,333,-322,158,-323,234,229,33,-188,133,410,78,-181,29,-82,196,203,287,116,483,-198,97,-144,393,-147,227,376,359,-301,416,202,157,-94,23,1,59,-167,364,-4,477,31,353,-63,477,440,307,-426,114,26,334,264,105,362,392,-355,342,-324,64,252,225,50,190,-371,180,-220,316,-311,106,396,473,89,300,473,491,-73,192,153,21,323,409,258,39,367,414,-23,484,465,41,370,175,320,357,351,449,-325,319,390,364,470,155,-89,491,235,362,229,164,392,109,-52,106,-347,145,-99,129,-185,159,106,47,96,252,-292,121,-384,420,-465,225,-269,63,-250,486,-272,198,34,436,-184,75,-111,188,429,440,-59,327,-381,148,-431,108,-282,257,-204,116,490,113,141,357,-263,262,45,229,-322,309,-425,43,442,91,305,112,-276,207,-282,110,-23,96,-46,132,-499,455,480,441,475,337,81,97,250,255,-397,63,218,112,41,20,175,136,-108,432,382,400,162,435,455,310,82,367,-178,200,350,140,-282,410,-307,366,-411,397,-375,407,351,39,-438,122,157,394,-141,301,192,199,-86,214,-447,378,220,391,458,273,127,57,-150,214,113,244,-13,363,-404,329,-264,95,-380,239,117,425,324,204,103,174,-283,338,-206,256,142,361,-120,65,-216,102,-266,1,-297,351,-448,200,186,345,-266,11,-351,45,81,161,-70,450,441,464,-420,487,180,227,-325,8,184,307,-261,129,160,13,-376,40,-312,215,-455,21,-219,196,50,213,-242,356,370,185,-154,433,484,79,260,409,211,500,470,232,-157,469,-17,376,140,57,246,138,-6,342,220,386,-306,93,-247,226,-444,467,137,288,-423,188,128,19,-71,479,278,458,340,86,-360,90,-163,454,-230,397,-83,90,495,191,-98,272,82,284,179,129,308,428,14,184,396,295,-126,193,-34,90,-483,89,-58,121,-369,500,-176,369,491,190,-134,246,-107,329,457,361,-366,289,472,157,-61,129,408,317,-482,130,-89,300,393,104,-342,285,255,317,-337,211,-154,124,-246,372,-190,449,369,382,-496,403,-180,500,-483,254,-119,33,5,65,-103,158,-463,121,-424,115,-218,276,329,256,299,57,290,456,-361,305,136,330,180,211,445,119,420,467,-401,472,-53,255,199,152,-77,32,-497,479,-258,5,-290,33,445,322,-252,324,-396,330,-163,243,-383,332,285,222,-172,468,-142,27,403,329,-416,129,-342,58,54,16,431,28,95,196,90,268,221,30,31,53,394,271,-190,42,449,484,-368,17,-2,220,-471,134,-240,450,421,194,26,412,239,187,418,67,387,364,184,377,162,269,14,105,171,39,-223,251,398,381,-365,105,343,420,-308,256,-440,100,-273,154,18,41,-418,72,-92,120,453,493,-53,185,-315,116,-261,96,-345,236,472,292,1,328,78,325,-265,160,7,190,-222,214,-84,401,44,102,-77,119,-490,25,-471,119,-391,154,-13,132,-86,46,-362,51,283,466,-249,79,-414,138,438,285,-353,78,-460,29,292,256,-240,7,241,344,-85,74,106,325,-112,184,-27,135,-215,119,-152,464,-202,257,-233,113,-469,360,-469,177,-160,365,-203,22,-187,288,-222,256,136,250,-120,49,-60,192,402,263,209,124,-131,427,-56,238,-373,91,-393,391,120,102,-230,345,-366,214,-438,257,367,383,208,183,413,377,-75,367,-410,141,473,278,106,96,-76,264,-295,225,-426,289,312,455,491,41,160,428,-138,181,58,328,197,249,-233,397,415,136,390,261,53,170,355,78,132,153,-210,390,-303,267,72,363,-290,434,-113,392,-259,191,419,238,-132,267,151,71,298,369,357,381,487,245,-451,348,-49,339,49,250,-456,275,342,4,-307,91,93,362,-2,477,-485,182,-397,326,309,42,8,185,-490,254,271,147,422,103,141,374,252,321,259,348,220,495,457,490,-351,183,99,61,21,108,-386,272,42,303,-396,167,-474,44,399,264,300,364,-476,4,396,272,310,369,-481,174,-210,7,132,250,106,406,-454,285,-110,72,91,161,448,247,-244,313,141,30,-281,106,48,263,-180,95,-140,266,335,153,-55,406,404,408,-270,131,43,322,-173,389,3,134,-142,416,-389,177,-475,63,383,358,308,305,395,332,87,188,325,16,123,305,-358,307,66,452,-376,344,104,337,-250,286,-78,190,-428,492,-125,236,319,462,-315,392,354,301,-15,67,83,272,265,220,87,358,94,301,38,458,62,360,443,74,480,468,367,7,-230,189,76,159,417,96,-24,157,-494,324,297,478,168,309,-257,265,-317,282,-284,423,-362,132,-213,483,249,87,-201,27,-73,132,366,283,196,273,-445,199,333,191,219,30,488,393,-197,81,-450,299,431,390,-209,225,-272,125,94,388,170,28,-338,35,-317,160,222,375,-136,123,80,332,455,293,-131,169,-345,413,470,235,425,165,359,62,206,58,-380,135,359,152,-72,12,209,250,118,19,-227,280,313,478,154,139,227,384,71,208,-67,80,212,254,317,366,-69,277,437,489,294,215,273,272,-362,253,-376,61,-361,179,-492,358,308,490,20,377,496,72,476,321,240,401,-380,461,-262,291,-163,90,-183,213,-425,71,497,181,-332,131,-303,149,-170,97,133,213,355,95,224,252,-1,207,150,435,67,285,284,244,-20,29,-149,360,-34,23,52,402,93,254,-144,107,-477,125,344,76,-248,200,-223,232,-389,335,-471,85,-54,471,-335,289,257,167,202,374,39,12,33,318,189,253,91,408,-322,425,-440,61,-405,402,-120,440,-195,109,-212,338,-285,218,-65,383,57,341,412,137,179,228,112,168,71,101,-16,103,221,116,124,65,464,18,111,237,174,274,163,111,-498,486,495,221,-111,6,-261,358,-264,72,374,445,-39,349,-57,339,117,24,215,407,-71,106,-414,231,364,248,-270,288,-182,285,-72,333,-396,302,-442,150,-309,302,-49,110,-447,52,178,295,89,405,378,171,-244,251,-98,480,-486,399,-93,171,-345,466,22,288,342,390,355,261,-487,357,442,89,-181,395,-326,319,451,470,383,149,19,262,46,357,124,319,-18,60,-67,9,-479,63,-190,148,-116,314,62,272,-116,124,-81,411,143,439,161,222,-266,68,204,111,16,252,44,403,-33,484,189,281,-498,848};

		Random rand = new Random();
//		int[] array = new int[10];
//		for(int i = 0; i < 10; i++) {
//			array[i] = rand.nextInt(20);
//		}
		System.out.println(Arrays.toString(array));
		quickSort.quickSort(array);
		System.out.println(Arrays.toString(array));

	}

}