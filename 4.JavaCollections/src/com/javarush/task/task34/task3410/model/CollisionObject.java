package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int newX = this.getX();
        int newY = this.getY();

        if (direction.equals(Direction.LEFT)) {
            newX -= Model.FIELD_CELL_SIZE;

        } else if (direction.equals(Direction.RIGHT)) {
            newX += Model.FIELD_CELL_SIZE;

        } else if (direction.equals(Direction.UP)) {
            newY -= Model.FIELD_CELL_SIZE;

        } else if (direction.equals(Direction.DOWN)) {
            newY += Model.FIELD_CELL_SIZE;
        }

        return gameObject.getX() == newX && gameObject.getY() == newY;
    }
}
