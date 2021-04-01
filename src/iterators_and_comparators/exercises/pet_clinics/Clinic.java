package iterators_and_comparators.exercises.pet_clinics;

public class Clinic {
    String name;
    private Pet[] rooms;

    public Clinic(String name, int roomsCount) {
        this.name = name;
        this.rooms = new Pet[roomsCount];
    }

    public void distributePet(Pet pet) {

        if (hasEmptyRooms()) {

            System.out.println(true);

            int centerIndex = this.rooms.length / 2;

            if (rooms[centerIndex] == null) {
                rooms[centerIndex] = pet;
            } else {
                int leftRoomIndex = centerIndex - 1;
                int rightRoomIndex = centerIndex + 1;

                findNextFreeRoom(this.rooms, leftRoomIndex, rightRoomIndex, pet);
            }
        } else {
            System.out.println(false);
        }
    }

    private void findNextFreeRoom(Pet[] rooms, int leftRoomIndex, int rightRoomIndex, Pet pet) {

        boolean lefRoomIndexInBounds = leftRoomIndex >= 0;
        boolean rightRoomIndexInBounds = rightRoomIndex <= rooms.length - 1;

        if (lefRoomIndexInBounds && rooms[leftRoomIndex] == null) {
            rooms[leftRoomIndex] = pet;
        } else if (rightRoomIndexInBounds && rooms[rightRoomIndex] == null) {
            rooms[rightRoomIndex] = pet;
        } else {
            leftRoomIndex--;
            rightRoomIndex++;
            if (lefRoomIndexInBounds || rightRoomIndexInBounds) {
                findNextFreeRoom(this.rooms, leftRoomIndex, rightRoomIndex, pet);
            }
        }
    }

    public void releaseAnimal() {
        int centerIndex = this.rooms.length / 2;
        boolean canReleaseAnimal = false;

        for (int i = centerIndex; i < this.rooms.length; i++) {

            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                canReleaseAnimal = true;
                break;
            }
        }

        if (!canReleaseAnimal) {

            for (int i = 0; i < centerIndex; i++) {
                if (this.rooms[i] != null) {
                    this.rooms = null;
                    canReleaseAnimal = true;
                    break;
                }
            }
        }

        System.out.println(canReleaseAnimal);
    }

    public boolean hasEmptyRooms() {
        boolean hasEmptyRooms = false;

        for (Pet room : this.rooms) {
            if (room == null) {
                hasEmptyRooms = true;
                break;
            }
        }
        return hasEmptyRooms;
    }

    public void printEntireClinic() {
        for (Pet room : this.rooms) {
            if (room == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(room.toString());
            }
        }
    }

    public void printRoom(int roomNumber) {
        if (this.rooms[roomNumber] != null) {
            System.out.println(this.rooms[roomNumber].toString());
        } else {
            System.out.println("Room empty");

        }
    }
}
