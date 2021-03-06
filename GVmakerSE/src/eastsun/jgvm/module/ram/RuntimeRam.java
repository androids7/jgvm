package eastsun.jgvm.module.ram;

/**
 * 运行时内存,提供运行时相关信息
 * @author Eastsun
 */
public final class RuntimeRam implements Ram {

    private int startAddr,  regionStartAddr,  regionEndAddr;
    private byte[] buffer;

    public RuntimeRam(int size) {
        buffer = new byte[size];
    }

    /**
     * 得到当前所在函数使用内存区域的起始地址
     * @return startAddr
     */
    public int getRegionStartAddr() {
        return regionStartAddr;
    }

    /**
     * 设置当前函数使用内存的起始地址
     * @param addr 起始地址
     */
    public void setRegionStartAddr(int addr) {
        regionStartAddr = addr;
    }

    /**
     * 得到当前所在函数使用内存区域的结束地址(不包括)
     * @return startAddr
     */
    public int getRegionEndAddr() {
        return regionEndAddr;
    }

    /**
     * 设置当前函数使用内存的结束地址
     * @param addr 起始地址
     */
    public void setRegionEndAddr(int addr) {
        regionEndAddr = addr;
    }

    public int size() {
        return buffer.length;
    }

    public int getRamType() {
        return Ram.RAM_RUNTIME_TYPE;
    }

    public int getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(int addr) {
        startAddr = addr;
    }

    public byte getByte(int addr) {
        return buffer[addr - startAddr];
    }

    public void setByte(int addr, byte data) {
        buffer[addr - startAddr] = data;
    }

    public void clear() {
        for (int index = buffer.length - 1; index >= 0; index--) {
            buffer[index] = 0;
        }
    }
}
