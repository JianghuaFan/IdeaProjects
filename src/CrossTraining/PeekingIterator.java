package CrossTraining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator {
    // TC: peek() O(1)  next() O(1)     hasNext() O(1)

    class peekingItegerator implements Iterator{
        // Initialize member variable
        private boolean hasPeeked;
        private Iterator<Integer> iterator;
        private Integer peekedElement;
        public peekingItegerator(Iterator<Integer> iterator){
            this.iterator = iterator;
        }
        // Return the next element in the iteration without advancing the iterator
        public Integer peek(){
            // case 1: we have not peeked the first element, when we need to peek we will hold next with peekedElement, set hasPeeked to true
            if(!hasPeeked){
                peekedElement = iterator.next();
                hasPeeked = true;
            }
            // case 2: we have already peeked the first element, next time if we want to peek, just return element
            return peekedElement;
        }
        @Override
        public Integer next(){
            if(!iterator.hasNext()){
                return null;
            }
            // case 1: we have already peeked the first element , set hasPeeked to false
            if(hasPeeked){
                Integer result = peekedElement;
                hasPeeked = false;
                peekedElement = null;
                return result;
            }
            // case 2: we have not peeked the first element, when we need to get next
            else{
                return iterator.next();
            }
        }
        @Override
        public boolean hasNext(){
            return hasPeeked || iterator.hasNext();
        }
    }

    public void IteratorTest(){
        List<Integer> list = new ArrayList<>();
//        Iterator<Integer> it = list.iterator();
        for (Iterator<Integer> it = list.iterator() ;  it.hasNext() ; ){
            Integer a = it.next();
            it.remove();
        }
    }

}
