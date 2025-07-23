package frc.robot.commands.driveCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveStop extends InstantCommand {
    private final RomiDrivetrain drive;
    public DriveStop() {
        drive = RomiDrivetrain.getinstance();
        addRequirements(drive);
    }

    @Override 
    public void execute() {
        drive.arcadeDrive(0, 0);
    }


}
