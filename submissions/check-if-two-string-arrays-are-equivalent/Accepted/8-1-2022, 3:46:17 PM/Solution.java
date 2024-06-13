// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent

class Solution {
    
     class StrIter{
        
        String[] strArr;
        int arridx;
        int stridx;
        
        public  StrIter(String[] strArr){
            this.strArr = strArr;
        }
        
        public boolean hasNext(){
            return arridx!=strArr.length;
        }
        
        public char next(){
            char c = strArr[arridx].charAt(stridx++);
            
            if(stridx==strArr[arridx].length()){
                arridx++;
                stridx=0;
            }
            return c;
            
        }
    }
    
    
    
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StrIter it1 = new StrIter(word1);
        StrIter it2 = new StrIter(word2);
        
        while(it1.hasNext() && it2.hasNext()){
            
            if(it1.next() != it2.next())
                return false;
            
        }
        
        return !it1.hasNext() && !it2.hasNext();
        
    }
}

// class Solution {

// 	class StringArrIterator {
// 		String[] strArr;
// 		int arrIdx;
// 		int strIdx;

// 		public StringArrIterator(String[] strArr) {
// 			this.strArr = strArr;
// 		}

// 		public boolean hasNext() {
// 			return arrIdx != strArr.length;
// 		}

// 		public char next() {
// 			char charAt = strArr[arrIdx].charAt(strIdx++);
// 			if (strIdx == strArr[arrIdx].length()) {
// 				arrIdx++;
// 				strIdx = 0;
// 			}
// 			return charAt;
// 		}
// 	}

// 	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
// 		StringArrIterator itr1 = new StringArrIterator(word1);
// 		StringArrIterator itr2 = new StringArrIterator(word2);
// 		while (itr1.hasNext() && itr2.hasNext()) {
// 			if (itr1.next() != itr2.next()) {
// 				return false;
// 			}
// 		}
// 		return !itr1.hasNext() && !itr2.hasNext();
// 	}
// }