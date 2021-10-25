class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
		map.put("Feb", "02");
		map.put("Mar", "03");
		map.put("Apr", "04");
		map.put("May", "05");
		map.put("Jun", "06");
		map.put("Jul", "07");
		map.put("Aug", "08");
		map.put("Sep", "09");
		map.put("Oct", "10");
		map.put("Nov", "11");
		map.put("Dec", "12");
        
        sb.append(date.substring(date.length() - 4, date.length()));
        sb.append('-');
        sb.append(map.get(date.substring(date.length() - 8, date.length() - 5)));
        sb.append('-');
        
        if(Character.isDigit(date.charAt(1)))
            sb.append(date.substring(0, 2));
        else {
            sb.append('0');
            sb.append(date.charAt(0));
        }
        
        return sb.toString();

    }
}