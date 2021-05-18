package question05.no2;
// 这次用动态规划
public class Finding {
    public static void main(String[] args) {
        String s1 = "abccbaeeffefe";
        String s2 = "hellohhahaha";
        String s3 = "abba";
        String s4 = "abfba";
        String s5 = "dfjdfajhdlfheiuroncewidsjjjdsksjkfjsdhjfhsdjhfjdsjhfjhsdhjfsjfneinewcneifiueuhfehfeiudsjkcn";
        String s6= "vaomxdtiuwqlwhgutkhxxhccsgvyoaccuicgybnqnslogtqhbl" +
                "egfudagpxfvjdacsxgevvepuwthdtybgflsxjdmmfumyqgpxatvdypjmla" +
                "pccaxwkuxkilqqgpihyepkilhlfkdrbsefinitdcaghqmhylnixidrygdnzmgu" +
                "beybczjceiybowglkywrpkfcwpsjbkcpnvfbxnpuqzhotzspgebptnhwevbkcueyz" +
                "ecdrjpbpxemagnwmtwikmkpqluwmvyswvxghajknjxfazshsvjkstkezdlbnkwxawlwkq" +
                "nxghjzyigkvqpapvsntojnxlmtywdrommoltpbvxwqyijpkirvndwpgufgjelqvwffpuycqfw" +
                "enhzrbzbdtupyutgccdjyvhptnuhxdwbmdcbpfvxvtfryszhaakwshrjseonfvjrrdefyxefqfvad" +
                "lwmedpvnozobftnnsutegrtxhwitrwdpfienhdbvvykoynrsbpmzjtotjxbvemgoxreiveakmmbbvbmfb" +
                "bnyfxwrueswdlxvuelbkrdxlutyukppkzjnmfmclqpkwzyylwlzsvriwomchzzqwqglpflaepoxcnnewzstve" +
                "gyaowwhgvcwjhbbstvzhhvghigoazbjiikglbqlxlccrwqvyqxpbtpoqjliziwmdkzfsrqtqdkeniulsavsfqsjwn" +
                "vpprvczcujihoqeanobhlsvbzmgflhykndfydbxatskf";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s6);
        System.out.println(result);
    }

}
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
