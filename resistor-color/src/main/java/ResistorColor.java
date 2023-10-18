class ResistorColor {
    String[] C={"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    
    int colorCode(String color) {
        for(int i=0;i<C.length;i++)
            if(C[i]==color)
                return i;
        return -1;
    }

    String[] colors() {
        return C;
    }
}

