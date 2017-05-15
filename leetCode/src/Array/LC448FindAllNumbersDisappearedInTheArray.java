package Array;

import java.util.ArrayList;
import java.util.List;

public class LC448FindAllNumbersDisappearedInTheArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		if(nums == null || nums.length == 0){
			return null;
		}

		List<Integer> list = new ArrayList<Integer>();

		for(int i = 0; i < nums.length; i++){
			if(nums[i] == nums[nums[i] - 1])continue;
			int temp = nums[nums[i] - 1];
			nums[nums[i] - 1] = nums[i];
			nums[i] = temp;
			i--;
		}

		for(int i = 0;i < nums.length;i++){
			System.out.print(nums[i]);
				if(nums[i] != i + 1){
				list.add(i + 1);
			}
		}


		return list;
	}

	public static void main(String[] args) {
		LC448FindAllNumbersDisappearedInTheArray test = new LC448FindAllNumbersDisappearedInTheArray();
		int[] nums = {4,3,2,7,8,2,3,1};

		test.findDisappearedNumbers(nums);

		}
	}
