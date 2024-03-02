import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] characterCodes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(result, characterCodes, "", digits, 0);

        return result;
    }

    private void backtrack(List<String> result, String[] characterCodes, String current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        char ch = digits.charAt(index);
        String codes = characterCodes[ch - '0'];

        for (char c : codes.toCharArray()) {
            backtrack(result, characterCodes, current + c, digits, index + 1);
        }
    }
}
