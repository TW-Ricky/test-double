package mock;

public class MockDoorPanel extends DoorPanel{
    @Override
    public void close() {
        System.out.println("MockDoorPanel is called");
    }
}
