// https://leetcode.com/problems/amount-of-new-area-painted-each-day


class Solution {
    private class Point {
        int idx;
        int x;
        boolean isStart;

        public Point(int idx, int x, boolean isStart) {
            this.idx = idx;
            this.x = x;
            this.isStart = isStart;
        }
    }

    public int[] amountPainted(int[][] paint) {
        int len = paint.length;
        int previous = -1;

        int[] worklog = new int[len];
        List<Point> points = new ArrayList<>();
        TreeSet<Integer> treeset = new TreeSet<>();
        for(int i = 0; i < len; i++) {
            points.add(new Point(i, paint[i][0], true));
            points.add(new Point(i, paint[i][1], false));
        }

        Collections.sort(points, new Comparator<>() {
            public int compare(Point a, Point b) {
                if(a.x < b.x) {
                    return -1;
                }
                if(a.x > b.x) {
                    return 1;
                }

                if(a.isStart && !b.isStart) {
                    return 1;
                }
                if(!a.isStart && b.isStart) {
                    return -1;
                }
               
                if(a.idx < b.idx) {
                    return -1;
                }
                if(a.idx > b.idx) {
                    return 1;
                }
                return 0;
            }
        });
        
        for(Point point : points) {
            if(point.isStart) {
                if(treeset.isEmpty()) {
                    previous = point.x;
                } else {
                    if(treeset.first() > point.idx) {
                        worklog[treeset.first()] += (point.x - previous);
                        previous = point.x;
                    }
                }
                treeset.add(point.idx);
            } else {
                if(treeset.first() == point.idx) {
                    worklog[treeset.first()] += (point.x - previous);
                    previous = point.x;
                }
                treeset.remove(point.idx);
            }
        }
        return worklog;
    }
}