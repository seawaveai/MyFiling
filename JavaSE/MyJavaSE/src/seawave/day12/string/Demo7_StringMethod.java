package seawave.day12.string;

public class Demo7_StringMethod {

	/**
	 * * A:String鐨勬浛鎹㈠姛鑳藉強妗堜緥婕旂ず
			* String replace(char old,char new)
			* String replace(String old,String new)
			
		* B:String鐨勫幓闄ゅ瓧绗︿覆涓ょ绌烘牸鍙婃渚嬫紨绀�
			* String trim()
			
		* C:String鐨勬寜瀛楀吀椤哄簭姣旇緝涓や釜瀛楃涓插強妗堜緥婕旂ず
			* int compareTo(String str)(鏆傛椂涓嶇敤鎺屾彙)
			* int compareToIgnoreCase(String str)(浜嗚В)
			 
			* 
	 */
	public static void main(String[] args) {
		//demo1();
		demo2();
		
		String s1 = "a";
		String s2 = "aaaa";
		
		int num = s1.compareTo(s2);				//鎸夌収鐮佽〃鍊兼瘮杈�
		System.out.println(num);
		
		String s3 = "榛�";
		String s4 = "椹�";
		int num2 = s3.compareTo(s4);
		//System.out.println('榛�' + 0);			//鏌ユ壘鐨勬槸unicode鐮佽〃鍊�
		//System.out.println('椹�' + 0);
		System.out.println(num2);
		
		String s5 = "heima";
		String s6 = "HEIMA";
		int num3 = s5.compareTo(s6);
		System.out.println(num3);
		
		int num4 = s5.compareToIgnoreCase(s6);
		System.out.println(num4);
		
		/*
		 * public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);						//灏哻1瀛楃杞崲鎴愬ぇ鍐�
                    c2 = Character.toUpperCase(c2);						//灏哻2瀛楃杞崲鎴愬ぇ鍐�
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);					//灏哻1瀛楃杞崲鎴愬皬鍐�
                        c2 = Character.toLowerCase(c2);					//灏哻2瀛楃杞崲鎴愬皬鍐�
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
		 */
	}

	private static void demo2() {
		String s = "   hei   ma   ";
		String s2 = s.trim();
		System.out.println(s2);
	}

	private static void demo1() {
		String s = "heima";
		String s2 = s.replace('i', 'o');			//鐢╫鏇挎崲i
		System.out.println(s2);
		
		String s3 = s.replace('z', 'o');			//z涓嶅瓨鍦�,淇濈暀鍘熷瓧绗︿笉鏀瑰彉
		System.out.println(s3);
		
		String s4 = s.replace("ei", "ao");
		System.out.println(s4);
	}


}
