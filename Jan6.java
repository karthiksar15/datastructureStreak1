  StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack();
        String[] paths = path.split("/");
        for (String str : paths) {
            if (str.equalsIgnoreCase("..") && (!stack.isEmpty())) {
                stack.pop();
            } else if (!(str.equalsIgnoreCase("..") ||
                    str.equalsIgnoreCase(".") ||
                    str.length() == 0)) {
                stack.push("/" + str);
            }
        }
        for (String str : stack) {
            result.append(str);
        }
        if (result.length() == 0)
            return result.append("/").toString();
        return result.toString();

