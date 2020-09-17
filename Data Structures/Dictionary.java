import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Node {

    String key, value;

    int height;
    Node left;
    Node right;
    Node(String key, String value) {
        this.key = key;
        this.height = 1;
        this.value = value;
    }
}

class Dictionary {

    Node root;

    static int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        // Return new root
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    String seek(Node node, String key){
        if(node == null)
            node = this.root;

        // check if key is at current node (is key found?)
        int comp = key.compareTo(node.key);

        if( comp == 0 ){ // key == node.key -> key found!
            // return definition
            return node.value;
        } else{
            // key > node.key -> seek right subtree
            if( comp > 0 && node.right != null )
                return seek( node.right, key );
            // key < node.key -> seek left subtree
            else if( comp < 0 && node.left != null )
                return seek( node.left, key );
        }

        return null;
    }


    Node insert(Node node, String key, String value) {
        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node(key, value));

        if ( key.compareTo(node.key) < 0 ) // handle add left
            node.left = insert(node.left, key, value);
        else if (key.compareTo(node.key) > 0) // handle add right
            node.right = insert(node.right, key, value);
        else if (key.compareTo(node.key) == 0) // handle same word
            // append definition to pre-existing definition
            node.value += "\n"+value;
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), height(node.right));

        /* 3. Get the balance factor of this ancestor
            node to check whether this node became
            unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0 )
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0 ) {
          node.left = leftRotate(node.left);
          return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0 )
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0 ) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    public static void main(String[] args) {

        Dictionary tree = new Dictionary();

        try {

            Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(args[0]))));

            String line; // input variable

            String[] keys = {};

            int count = 0; // number of key, defn. pairs -> for debugging

            String defn = ""; // accumulative string, may span multiple lines.

            while( scanner.hasNextLine() ){ // until EOF
                //*/
                line = scanner.nextLine().trim();

                if( !line.isEmpty() && // line not empty
                    Character.isLetter(line.charAt(0)) && // First character is a letter
                    line.equals( line.toUpperCase() )){ // uppercase string check


                    if( keys != null && keys.length > 0 ){ // already has keys

                        if( !(defn.trim().isEmpty()) ){ // if is not empty:
                            for(String k : keys){ // insert keys with defn.
                                count++;
                                tree.root = tree.insert(tree.root, k.trim(), defn);
                            }
                            // reset defn.
                            defn = "";
                            // redefine keys with new keys from current line
                            keys = line.split(";"); // see below for line explanation
                        }else // if defn is empty... just append
                            defn += line+"\n";
                    }else // if no keys (first word encountered for ex.)
                        keys = line.split(";");
                }else{

                    defn += line+"\n";
                }
            }

            if( !defn.trim().isEmpty() && keys != null && keys.length > 0){
                for(String k : keys){
                    count++;
                    tree.root = tree.insert(tree.root, k.trim(), defn);
                }
            }

            // All words inserted
            // output height of tree
            System.out.printf("%d\n", tree.height(tree.root));
            // redefine scanner to accept input from user
            scanner = new Scanner(System.in);
            // input loop
            input_loop( tree, scanner );

        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    public static void input_loop( Dictionary lexicon, Scanner scanner ){

        String str = "";
        String[] split;

        do{

            System.out.printf("$ ");
            str = scanner.nextLine().toUpperCase().trim();

            if( str.equals("EXIT") ) break; // exit program

            split = str.split(" "); // separate words

            if( split[0].equals("SEARCH") ){

                // if word NOT found -> str = null;
                // if word IS  found -> str = <definition>;
                str = lexicon.seek(lexicon.root, split[1] );

                if( str == null ){ // interpret word not found.
                    System.out.printf("%s does not exist\n", split[1] );
                }else{ // print definition
                    System.out.printf("%s\n", str);
                }

            }else{
                System.out.printf("Invalid command\n");
            }

        }while( true );

    }

}
