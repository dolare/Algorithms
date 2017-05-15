package string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import string.Permutation;

public class TestString {

	@Test
	public void testPermutation() {
		
		Permutation p1 = new Permutation();
		ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
		int[] input1 = {1,2,3};
		ArrayList<Integer> r1 =
			    new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<Integer> r2 =
			    new ArrayList<Integer>(Arrays.asList(1,3,2));
		ArrayList<Integer> r3 =
			    new ArrayList<Integer>(Arrays.asList(2,1,3));
		ArrayList<Integer> r4 =
			    new ArrayList<Integer>(Arrays.asList(2,3,1));
		ArrayList<Integer> r5 =
			    new ArrayList<Integer>(Arrays.asList(3,1,2));
		ArrayList<Integer> r6 =
			    new ArrayList<Integer>(Arrays.asList(3,2,1));
		
		result.add(r1);
		result.add(r2);
		result.add(r3);
		result.add(r4);
		result.add(r5);
		result.add(r6);
		
        assertEquals(result, p1.permute(input1));
        
        
        
        assertEquals(3, 3);
	}

}
