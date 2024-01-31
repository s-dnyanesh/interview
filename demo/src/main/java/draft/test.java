package draft;

public class test {
	public static void main(String [] args){
        String[] nums = {"One", "Two", "Three", "Four", "Five", "Six", "Sev"};
        for(int i = 0; i < nums.length; i++) {
            if (nums[i++].length() % 3 == 0) {
            	i=i;
                continue;
            }
            System.out.println(nums[i]);
            break;
        }
}

}
