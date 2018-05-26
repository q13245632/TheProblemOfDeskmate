public class Solution {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        // 根据斜杠分割路径
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i];
            // “..”表示返回路径的上级目录（如果当前是根目录则不处理），“.”表示当前目录
            // 如果当前目录不是..和.，即不是返回上级目录和当前目录，将路径保存到栈中
            if(!curr.equals("..") && !curr.equals(".") && !curr.equals("")){
                stack.push(curr);
            }
            // 如果是返回上级目录，弹出当前栈顶路径
            if(curr.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }
        // 栈底的路径越靠前
        String result = "";
        while (!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        // 如果为空，返回根目录 “/”
        return result.equals("") ? "/" : result;
    }
}