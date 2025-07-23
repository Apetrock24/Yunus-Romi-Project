package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class RomiDrivetrain extends SubsystemBase {
    private static final RomiDrivetrain instance;

    static {
        instance = new RomiDrivetrainimpl();
    }

    public static RomiDrivetrain getinstance() {
        return instance;
    }

    public abstract void arcadeDrive (double xAxisSpeed, double zaxisRotate);

    public abstract void resetEncoders();

    public abstract double getLeftDistanceInch();
    public abstract double getRightDistanceInch();

    public abstract double getGyroX();
    public abstract double getGyroY();
    public abstract double getGyroZ();

    
}
