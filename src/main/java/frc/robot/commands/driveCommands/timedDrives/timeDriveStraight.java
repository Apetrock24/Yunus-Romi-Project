package frc.robot.commands.driveCommands.timedDrives;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.RomiDrivetrain;

public class timeDriveStraight extends InstantCommand {
    private final RomiDrivetrain drive = RomiDrivetrain.getinstance();
    private double time;
    private double speed;
    Timer timer = new Timer();
    public timeDriveStraight(double time, double speed) {
        this.time = time;
        this.speed = time;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.arcadeDrive(speed, 0);
        timer.start();
        SmartDashboard.putNumber("TimeDrive/ timer", timer.get());
    }

    @Override 
    public boolean isFinished() {
        boolean isfinished = false;
        if (timer.get() >= time) {
            isfinished = true;
            timer.stop();
            timer.reset();
        }
        return isfinished;
    }

}
