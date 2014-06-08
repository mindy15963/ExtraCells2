package extracells.network.packet.part;

import extracells.network.AbstractPacket;
import extracells.part.PartFluidStorage;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketBusFluidStorage extends AbstractPacket {

    PartFluidStorage part;

    public PacketBusFluidStorage() {
    }

    public PacketBusFluidStorage(EntityPlayer _player, PartFluidStorage _part) {
        super(_player);
        mode = 0;
        player = _player;
        part = _part;
    }

    public void writeData(ByteBuf out) {
        writePart(part, out);
    }

    public void readData(ByteBuf in) {
        part = (PartFluidStorage) readPart(in);
    }

    @Override
    public void execute() {
        switch (mode) {
            case 0:
                part.sendInformation(player);
                break;
        }
    }
}
