package com.github.T_ccbr_pll_NG.utils.utilssecurity;

public class Convert {

    private static  Mycypher mycypher;

    public static void main(String[] args) throws Exception {
        mycypher = new Mycypher();
        System.out.println(mycypher.encrypt("$$##UCD765DIVNFINdcodmc87654567"));
    }
}
