package frc.robot.commands.driveCommands.TurnCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RomiDrivetrain;

public class turntodegree extends Command{
    private final RomiDrivetrain drivetrain = RomiDrivetrain.getinstance();
    private Rotation2d targetangle;
    public turntodegree(double degree) {
        targetangle = Rotation2d.fromDegrees(degree);
        addRequirements(drivetrain);
    }

    @Override 
    public void execute() {
        
    }
}
