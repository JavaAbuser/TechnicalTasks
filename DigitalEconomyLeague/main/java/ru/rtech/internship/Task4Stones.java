package ru.rtech.internship;

public class Task4Stones {

    /**
     * Баллов за выполнение - 2
     *
     * У нас есть N камней и M людей на входе. Делаем следующие:
     * Берем из стопки 1 камушек, даем первому человеку, дальше берем 2 камушка, даем второму человеку,
     * дальше 3 камушка и т.п. То есть, каждый раз берем N+1 камень. Если люди кончились, а камни остались,
     * то продолжаем раздачу с первого человека.
     *
     * На входе - количество людей, количество камней
     * На выходе - массив, у кого сколько камней
     *
     * Камней = 3, людей = 5 -> [1,2,0,0,0]
     * Камней = 3, людей = 2 ->  [1,2]
     * Камней = 10, людей = 3 -> [5,2,3]
     * Камней = 2, людей = 4 -> [1,1,0,0]
     *
     */

    public int[] peopleAndStones(int peopleNumber, int stonesNumber){
        int[] array = new int[peopleNumber];
        int stonesCount = 1;
        int count = 0;
        int humanId = 0;
        while(count < stonesNumber){
            if(humanId < peopleNumber){
                if(stonesNumber < 3){
                    array[humanId] += 1;
                } else {
                    array[humanId] += stonesCount;
                }
                count += stonesCount;
                humanId++;
                stonesCount++;
            } else{
                humanId = 0;
            }
        }

        return array;
    }
}
