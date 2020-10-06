class TestBigNumber {
    public static void main(String[] args) {
	BigNumber n1 = new BigNumber("1");
	//System.out.println(n1);	
	BigNumber n2 = new BigNumber("2");
	//System.out.println(n2);
	BigNumber n3 = new BigNumber("2361736176326363");
	//System.out.println(n3);
	BigNumber n4 = new BigNumber("7362767647676737");
	//System.out.println(n4);
	BigNumber n5 = new BigNumber("12378123783987389174692846829");
	//System.out.println(n5);
	BigNumber n6 = new BigNumber("87621876216012610825307153171");
	//System.out.println(n6);
	BigNumber n7 = new BigNumber("28347923749823749872395872985798598579585");
	//System.out.println(n7);

	/*
	BigNumber n8 = n1.add(n2);
	BigNumber ns1 = new BigNumber("3");
	System.out.println(n1+"+"+n2+": "+n8.equals(ns1)+":"+n8);
	System.out.println("");

	System.out.println(n3);
	System.out.println(n2);
	BigNumber n9 = n3.add(n2);
	BigNumber ns2 = new BigNumber("2361736176326365");
	System.out.println("numero: "+ns2);
	System.out.println(n3+"+"+n2+": "+n9.equals(ns2)+": "+ns2);
	System.out.println("");

	System.out.println(n3);
	System.out.println(n4);
	BigNumber n10 = n3.add(n4);
	BigNumber ns3 = new BigNumber("9724503824003100");
	System.out.println("numero: "+ns3);
	System.out.println(n3+"+"+n4+": "+n10.equals(ns3)+": "+ns3);
	System.out.println("");

	System.out.println(n4);
	System.out.println(n5);
	BigNumber n11 = n4.add(n5);
	BigNumber ns4 = new BigNumber("12378123783994751942340523566");
	System.out.println("numero: "+ns4);
	System.out.println(n4+"+"+n5+": "+n11.equals(ns4)+": "+ns4);
	System.out.println("");
	

	System.out.println(n6);
	System.out.println(n5);
	BigNumber n12 = n6.add(n5);
	BigNumber ns5 = new BigNumber("100000000000000000000000000000");
	System.out.println("numerof: "+ns5);
	System.out.println(n6+"+"+n5+": "+n12.equals(ns5)+": "+ns5);
	System.out.println("");
	*/
	System.out.println(n5);
	System.out.println(n6);
	BigNumber n13 = n5.add(n6);
	BigNumber ns6 = new BigNumber("100000000000000000000000000000");
	System.out.println("numerof: "+ns6);
	System.out.println(n5+"+"+n6+": "+n13.equals(ns6)+": "+ns6);
	System.out.println("");

	System.out.println(n6);
	System.out.println(n7);
	BigNumber n14 = n6.add(n7);
	BigNumber ns7 = new BigNumber("28347923749911371748611885596623905732756");
	System.out.println("numerof: "+ns7);
	System.out.println(n6+"+"+n7+": "+n14.equals(ns7)+": "+ns7);
	System.out.println("");

	System.out.println(n14);
	System.out.println(n13);
	BigNumber n15 = n14.add(n13);
	BigNumber ns8 = new BigNumber("28347923750011371748611885596623905732756");
	System.out.println("numerof: "+ns8);
	System.out.println(n14+"+"+n13+": "+n15.equals(ns8)+": "+ns8);
	System.out.println("");
   
	BigNumber n16 = n15.add(n14);
	BigNumber ns9 = new BigNumber("56695847499922743497223771193247811465512");
	System.out.println(n16.equals(ns9)+": "+ns9);
    }
}
