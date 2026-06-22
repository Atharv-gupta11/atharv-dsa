class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        if (t.length() == s.length()) {
            if (s.equals(t)) return s;
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        int mins = -1;
        int mine = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            System.out.println(isValid(smap,tmap)+" "+r);
            while (isValid(smap, tmap)) {
                char lch = s.charAt(l);
                if(r-l+1<min){
                    min=r-l+1;
                    mins=l-1;
                    mine=r;
                }
                smap.put(lch, smap.get(lch) - 1);
                if (smap.get(lch) == 0) {
                    smap.remove(lch);
                }

                l++;
            }
            r++;
        }
        System.out.println(mins+" "+mine);
        return s.substring(mins+1, mine + 1);
    }

    public boolean isValid(HashMap<Character, Integer> smap,
                           HashMap<Character, Integer> tmap) {

        boolean valid = true;

        for (char ch : tmap.keySet()) {
            if (!smap.containsKey(ch) || smap.get(ch)<tmap.get(ch)) {
                valid = false;
                break;
            }
        }

        return valid;
    }
}