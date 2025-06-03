//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class gfg1 {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        return 0;
    }
}