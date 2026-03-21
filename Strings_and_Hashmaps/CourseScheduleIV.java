package Strings_and_Hashmaps;
import java.util.*;
public class CourseScheduleIV {

    public static void main(String[] args) {
        int courses = 5;
        int [][] pre_requisites = {{0,1},{1,2}, {2,3} , {3,4}} , queries = {{0,4} , {4,0} , {1,3} , {3,0}};
        System.out.println(checkIfPrerequisite(courses , pre_requisites , queries));
    }

    static List<Boolean>
    checkIfPrerequisite(int courses , int [][] pre_requisites , int [][] queries) {
        HashMap<Integer , HashSet<Integer>> mp = new HashMap<>();

        //initialize
        for( int i = 0 ; i < courses ; i++ ){
            mp.put(i , new HashSet<>());
        }

        for( int [] p : pre_requisites) {
            int course =  p[1];
            int pre_requisite = p[0];
            mp.get(course).add(pre_requisite);
            //traverse in each prerequisite and add those for the indirect prerequisite
            //FIND THE MIN NODE
        }
        int min_node = -1;
        for( int i : mp.keySet()) {
            if(mp.get(i).isEmpty()) {
                min_node = i;
                break;
            }
        }

        List<Boolean> ans = new ArrayList<>();
        System.out.println(mp);
        for( int [] i : queries ) {
            int u = i[0];
            int v = i[1];
            if(!mp.get(v).isEmpty() && mp.get(v).contains(u)) {
                ans.add(true);
            }
            else {
                ans.add(false);
            }
        }
        return ans;
    }
}
