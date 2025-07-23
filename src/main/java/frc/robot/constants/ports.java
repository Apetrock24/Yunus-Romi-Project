package frc.robot.constants;

public class ports {
    public interface Ports {
        public final int LEFT_ENCODER_CHANNELA = 4;
        public final int LEFT_ENCODER_CHANNELB = 5;
        public final int RIGHT_ENCODER_CHANNELA = 6;
        public final int RIGHT_ENCODER_CHANNELB = 7;
        
        public final int LEFT_MOTOR_CHANNEL = 0;
        public final int RIGHT_MOTOR_CHANNEL = 1;
    }
    public interface Controller {
        public interface leftstick {
            public final int X = 0;
            public final int y = 1;
        }
        public interface rightStick {
            public final int x = 2;
            public final int y = 5;
        } 
        
        
    }
}
