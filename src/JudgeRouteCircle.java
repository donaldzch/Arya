public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int vertical=0, horizontal=0;
        for (char move: moves.toCharArray()) {
            if (move == 'U')
                vertical +=1;
            else if (move == 'D')
                vertical -=1;
            else if (move == 'L')
                horizontal +=1;
            else
                horizontal -=1;
        }
        return (vertical == 0) && (horizontal == 0);
    }

    public boolean judgeCircle1(String moves) {
        int vertical=0, horizontal=0;
        for (char move: moves.toCharArray()) {
            switch (move) {
                case 'U': vertical++;
                case 'D': vertical--;
                case 'L': horizontal++;
                case 'R': horizontal--;
            }
        }
        return (vertical == 0) && (horizontal == 0);
    }
}
