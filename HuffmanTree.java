import java.util.HashMap;

public class HuffmanTree{
    Node root;

   public HashMap<Character, String> getCodes() {
       HashMap<Character, String> binaryMap = new HashMap<>();
       generateCodes(this.root, "", binaryMap);

        return binaryMap;
   }

   private void generateCodes(Node actual, String prefix, HashMap<Character, String> binaryMap) {
       if (actual == null) {
           return;
       }

       if (actual.left == null && actual.right == null) {
           binaryMap.put(actual.character, prefix);

       } else {
           generateCodes(actual.left, prefix + "0", binaryMap);

           generateCodes(actual.right, prefix + "1", binaryMap);
       }
   }
}
