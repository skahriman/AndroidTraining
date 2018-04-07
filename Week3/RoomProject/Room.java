public class Room {
	public final boolean isInfected;
	public boolean visited = false;

	public Room(boolean infected) {
		isInfected = infected;
	}

	public static boolean isOutbreak(Room[][] floor) {
		for (int i = 0; i < floor.length; i++) {
			for (int j = 0; j < floor[i].length; j++) {
				if (countConnectedRooms(floor, i, j) >= 5)
					return true;
			}
		}
		return false;
	}

	public static int countConnectedRooms(Room[][] floor, int i, int j) {
		
		int result = 0;

		if (i >= 0 && i < floor.length && j >= 0 && j < floor[0].length) {
			if (floor[i][j].isInfected && !floor[i][j].visited) {
				floor[i][j].visited = true;
				return 1 + countConnectedRooms(floor, i-1, j) + countConnectedRooms(floor, i + 1, j)
						+ countConnectedRooms(floor, i, j-1) + countConnectedRooms(floor, i, j + 1);
			} else {
				return 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Room[][] verticalTrue = new Room[][] {
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(true), new Room(true),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) } };

		Room[][] horizontalTrue = new Room[][] {
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(true), new Room(true), new Room(true),
						new Room(true), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) } };

		Room[][] noInfection = new Room[][] {
				{ new Room(true), new Room(false), new Room(true), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(true), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(true), new Room(false), new Room(true), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(true), new Room(false),
						new Room(true), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(true),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(true), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(true), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) },
				{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
						new Room(false), new Room(false), new Room(false), new Room(false) } };

		System.out.println(isOutbreak(noInfection));
		System.out.println(isOutbreak(horizontalTrue));
		System.out.println(isOutbreak(verticalTrue));
	}

}