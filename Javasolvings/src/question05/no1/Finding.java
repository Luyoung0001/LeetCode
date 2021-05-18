package question05.no1;

import java.util.*;
// 这个算法的思路是：首先求这个字符串的所有子串，然后将每个子串用check()方法判断是否为回文串，如果是，就存储在strings数组里。
// 再对这个超大的数组进行优化，将<strings[i].length, strings[i]>存放在HashMap中。接着
// 对HashMap进行key.set()得到所有的keyset。再将keyset转化成数组，对数组排序后拿到最大的key,
// 再直接利用HashMap进行获取字符串就完成了。
public class Finding {
    public static void main(String[] args) {
        String s1 = "abccbaeeffefe";
        String s2 = "hellohhahaha";
        String s3 = "abba";
        String s4 = "abfba";
        String s5 = "dfjdfajhdlfheiuroncewidsjjjdsksjkfjsdhjfhsdjhfjdsjhfjhsdhjfsjfneinewcneifiueuhfehfeiudsjkcn";
        String s6= "vaomxdtiuwqlwhgutkhxxhccsgvyoaccuicgybnqnslogtqhblegfudagpxfvjdacsxgevvepuwthdtybgflsxjdmmfumyqgpxatvdypjmlapccaxwkuxkilqqgpihyepkilhlfkdrbsefinitdcaghqmhylnixidrygdnzmgubeybczjceiybowglkywrpkfcwpsjbkcpnvfbxnpuqzhotzspgebptnhwevbkcueyzecdrjpbpxemagnwmtwikmkpqluwmvyswvxghajknjxfazshsvjkstkezdlbnkwxawlwkqnxghjzyigkvqpapvsntojnxlmtywdrommoltpbvxwqyijpkirvndwpgufgjelqvwffpuycqfwenhzrbzbdtupyutgccdjyvhptnuhxdwbmdcbpfvxvtfryszhaakwshrjseonfvjrrdefyxefqfvadlwmedpvnozobftnnsutegrtxhwitrwdpfienhdbvvykoynrsbpmzjtotjxbvemgoxreiveakmmbbvbmfbbnyfxwrueswdlxvuelbkrdxlutyukppkzjnmfmclqpkwzyylwlzsvriwomchzzqwqglpflaepoxcnnewzstvegyaowwhgvcwjhbbstvzhhvghigoazbjiikglbqlxlccrwqvyqxpbtpoqjliziwmdkzfsrqtqdkeniulsavsfqsjwnvpprvczcujihoqeanobhlsvbzmgflhykndfydbxatskf";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s6);
        System.out.println(result);
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        HashMap<Integer, String> hashMap = new HashMap<>();
        String[] strings = new String[len*(len+1)/2];
        int couner = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j <= len; j++){
                String ret = s.substring(i, j);
                // System.out.println(ret);
                if(check(ret)){
                    strings[couner++] = ret;
                }
            }

        }
        for(int i = 0; i < strings.length; i++){
            // System.out.println(strings[i]);
            if(strings[i] != null){
                hashMap.put(strings[i].length(),strings[i]);
            }
        }
        Set<Integer> set=hashMap.keySet();

        int no = set.size();
        int i = 0;
        Integer[] integers = new Integer[no];
        for(Integer integer : set) {
            // System.out.println(hashMap.get(integer));
            integers[i++] = hashMap.get(integer).length();
        }
        Arrays.sort(integers);
        //System.out.println(max);
        return hashMap.get(integers[no-1]);

    }
    public boolean check(String si) {
        char[] chars = si.toCharArray();
        int len = chars.length;
        if (len % 2 == 0) {
            for (int i = 0; i < len / 2; i++) {
                if (chars[i] != chars[len - i - 1]) {
                    return false;
                }
            }
            return true;
        } else{
            for (int i = 0; i < len / 2; i++) {
                if (chars[i] != chars[len - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
