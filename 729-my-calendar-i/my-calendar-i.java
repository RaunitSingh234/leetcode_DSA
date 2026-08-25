class MyCalendar {
    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<int[]>();
    }
    
    public boolean book(int startTime, int endTime) {
        if (bookings.size() == 0){
            bookings.add(new int[] {
                startTime,
                endTime - 1
            });
            return true;
        }
        for(int i = 0; i<bookings.size(); i = i +1){
            int s1 = bookings.get(i)[0];
            int e1 = bookings.get(i)[1];
            int s2 = startTime;
            int e2 = endTime - 1;
            if( e1 >= s2 && e2 >= s1) {
                return false;
            }
        }
        bookings.add(new int[] {
            startTime,
            endTime - 1
        });
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */