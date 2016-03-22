import java.util.*;
public class WayFair{
	public static void main(String[] args){
		int[] nums = {3, -1, 2,0,-1,-8,-6,5, -7};
		moveNegative(nums);
		moveNegative2(nums);

		int[] nums1 = {1,0,8,-7,-3,-6,6,-2,5};
		moveNegative3(nums1);

		int[] nums2 = {1,0,8,-7,-3,-6,6,-2,5};
		System.out.println(randomOne(nums2));

		randomK(nums2, 4);

		int[] nums3 = {3, -1, 2,0,-1,-8,-6,5, -7};
		maximunSubArray(nums3);
	}

	public static void moveNegative(int[] nums){
		if(nums == null || nums.length == 0) return;
		int[] x = new int[nums.length];
		int negIdx = 0;
		int posIdx = nums.length-1;
		int len = nums.length;

		for(int i = 0; i  < nums.length; i++){
			if(nums[i] < 0){
				x[negIdx++] = nums[i];
			}

			if(nums[len-1-i] >= 0){
				x[posIdx--] = nums[len-1-i];
			}
		}

		for(int i : x){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void moveNegative2(int[] nums){
		if(nums == null || nums.length == 0) return;
		int i = 0;
		for(int j = 0; j < nums.length; j++){
			if(nums[j] < 0){
				int temp = nums[j];
				int k = j;
				while(k > i){
					nums[k] = nums[k-1];
					k--;
				}
				nums[i] = temp;
				i++;
			}
		}

		for(int num : nums){
			System.out.print(num + " ");
		}
		System.out.println();
	}
	

	public static void moveNegative3(int[] nums){
		if(nums == null || nums.length == 0) return;

		int i = 0;
		for(int j = 0; j < nums.length; j++){
			if(nums[i] < 0){
				i++;
			}else if(nums[j] < 0){
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
			}
		}

		for(int num : nums){
			System.out.print(num + " ");
		}
		System.out.println();
	}

	

	public static int randomOne(int[] nums){
		if(nums == null || nums.length == 0) return -1;
		Random random = new Random();
		int idx = random.nextInt(nums.length);
		return nums[idx];
	}

	public static void randomK(int[] nums, int k){
		if(nums == null || nums.length == 0) return;

		int i = 0;
		List<Integer> res = new ArrayList<>();
		int len = nums.length;

		Random random = new Random();

		while(i < k){
			int idx = random.nextInt(len--);
			res.add(nums[idx]);
			int temp = nums[idx];
			nums[idx] = nums[len];
			nums[len] = temp;
			i++; 
		}

		for(int num : res){
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void maximunSubArray(int[] nums){
		if(nums == null || nums.length == 0) return;

		int max = nums[0];
		int[] dp = new int[nums.length];
		List<Integer> res = new ArrayList<>();
		dp[0] = nums[0];
		res.add(0);
		for(int i = 1; i < nums.length; i++){
			if(dp[i-1] + nums[i] > nums[i]){
				dp[i] = dp[i-1] + nums[i];
				if(dp[i] > max){
					max = dp[i];
					res.add(i);
				}
			}else{
				dp[i] = nums[i];
				if(dp[i] > max){
					res = new ArrayList<>();
					res.add(i);
					max = dp[i];
				}

			}
		}

		int s = res.get(0);
		int e = res.get(res.size()-1);
		for(int i = s; i <= e; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
}