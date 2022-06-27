package top.bing6749.domain;
/*
 * @author  MaRui
 * @date  2022/6/22 22:06
 * @version 1.0
 */


import lombok.Data;

import java.io.Serializable;

/**
 * @author MaRui
 */
@Data
public class CPUProductCountDistribution implements Serializable {
    public int AMD;
    public int intel;
}
