package com.example.jnick.discriminators;

/**
 * @author fabian
 */
public class DoubleConsonantDiscriminator extends Discriminator {

    private       boolean[][] positionsMatrix;
    private final short
        BB =   0, BH =   1, BL =   2, BR =   3, BS =   4, BY =   5, BZ =   6,
        CC =   7, CH =   8, CL =   9, CR =  10, DD =  11, DG =  12, DH =  13,
        DK =  14, DM =  15, DR =  16, DS =  17, DW =  18, DY =  19, FF =  20,
        FL =  21, FN =  22, FR =  23, FS =  24, FZ =  25, GG =  26, GH =  27,
        GL =  28, GM =  29, GR =  30, HW =  31, HY =  32, JW =  33, KH =  34,
        KK =  35, KL =  36, KN =  37, KR =  38, KS =  39, KY =  40, LB =  41,
        LC =  42, LD =  43, LF =  44, LG =  45, LK =  46, LL =  47, LM =  48,
        LS =  49, LT =  50, LW =  51, LY =  52, LZ =  53, MB =  54, MY =  55,
        NB =  56, NC =  57, ND =  58, NF =  59, NG =  60, NK =  61, NN =  62,
        NP =  63, NQ =  64, NS =  65, NT =  66, NX =  67, NY =  68, NZ =  69,
        PH =  70, PL =  71, PN =  72, PP =  73, PR =  74, PS =  75, PT =  76,
        PX =  77, PY =  78, RB =  79, RC =  80, RD =  81, RF =  82, RG =  83,
        RJ =  84, RK =  85, RL =  86, RM =  87, RN =  88, RP =  89, RQ =  90,
        RR =  91, RS =  92, RT =  93, RV =  94, RY =  95, RZ =  96, SB =  97,
        SC =  98, SG =  99, SH = 100, SK = 101, SL = 102, SM = 103, SN = 104,
        SP = 105, SQ = 106, SS = 107, ST = 108, SV = 109, SW = 110, SY = 111,
        TH = 112, TL = 113, TR = 114, TS = 115, TT = 116, TW = 117, TY = 118,
        TZ = 119, VL = 120, VN = 121, VR = 122, VS = 123, VV = 124, VY = 125,
        VZ = 126, WC = 127, WG = 128, WK = 129, WM = 130, WT = 131, WX = 132,
        XT = 133, XX = 134, YB = 135, YD = 136, YL = 137, YM = 138, YP = 139,
        YR = 140, YS = 141, YT = 142, YV = 143, YZ = 144, ZB = 145, ZC = 146,
        ZD = 147, ZF = 148, ZG = 149, ZK = 150, ZN = 151, ZY = 152, ZZ = 153;

    private final String DOUBLE_CONSONANTS
        = "bb-bh-bl-br-bs-by-bz-"
        + "cc-ch-cl-cr-"
        + "dd-dg-dh-dk-dm-dr-ds-dw-dy-"
        + "ff-fl-fn-fr-fs-fz-"
        + "gg-gh-gl-gm-gr-"
        + "hw-hy-"
        + "jw-"
        + "kh-kk-kl-kn-kr-ks-ky-"
        + "lb-lc-ld-lf-lg-lk-ll-lm-ls-lt-lw-ly-lz-"
        + "mb-my-"
        + "nb-nc-nd-nf-ng-nn-nk-np-nq-ns-nt-nx-ny-nz-"
        + "ph-pl-pn-pp-pr-ps-pt-px-py-"
        + "qu-"
        + "rb-rc-rd-rf-rg-rj-rk-rl-rm-rn-rp-rq-rr-rs-rt-rv-ry-rz-"
        + "sb-sc-sg-sh-sk-sl-sm-sn-sp-sq-ss-st-sv-sw-sy-"
        + "th-tl-tr-ts-tt-tw-ty-tz-"
        + "vl-vn-vr-vs-vv-vy-vz-"
        + "wc-wg-wj-wm-wt-wx-"
        + "xt-xx-"
        + "yb-yd-yl-ym-yp-yr-ys-yt-yv-yz-"
        + "zb-zc-zd-zf-zg-zk-zn-zy-zz";


    public DoubleConsonantDiscriminator() {
        initPositionsMatrix();
    }


    /**
     * {@inheritDoc}
     * */
    @Override public boolean isValid(String doubleCharacter) {
        for(String doubleConsonant:DOUBLE_CONSONANTS
                .split(CHARACTER_SEPARATOR)) {
            if(doubleCharacter.equals(doubleConsonant)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public short getCollectionSize() {
        return (short)
            DOUBLE_CONSONANTS
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public boolean[] getValidPositions(String doubleConsonant) {
        switch(doubleConsonant) {
            case "bb": return positionsMatrix[BB];
            case "bh": return positionsMatrix[BH];
            case "bl": return positionsMatrix[BL];
            case "br": return positionsMatrix[BR];
            case "bs": return positionsMatrix[BS];
            case "by": return positionsMatrix[BY];
            case "bz": return positionsMatrix[BZ];
            case "cc": return positionsMatrix[CC];
            case "ch": return positionsMatrix[CH];
            case "cl": return positionsMatrix[CL];
            case "cr": return positionsMatrix[CR];
            case "dd": return positionsMatrix[DD];
            case "dg": return positionsMatrix[DG];
            case "dh": return positionsMatrix[DH];
            case "dk": return positionsMatrix[DK];
            case "dm": return positionsMatrix[DM];
            case "dr": return positionsMatrix[DR];
            case "ds": return positionsMatrix[DS];
            case "dw": return positionsMatrix[DW];
            case "dy": return positionsMatrix[DY];
            case "ff": return positionsMatrix[FF];
            case "fl": return positionsMatrix[FL];
            case "fn": return positionsMatrix[FN];
            case "fr": return positionsMatrix[FR];
            case "fs": return positionsMatrix[FS];
            case "fz": return positionsMatrix[FZ];
            case "gg": return positionsMatrix[GG];
            case "gh": return positionsMatrix[GH];
            case "gl": return positionsMatrix[GL];
            case "gm": return positionsMatrix[GM];
            case "gr": return positionsMatrix[GR];
            case "hw": return positionsMatrix[HW];
            case "hy": return positionsMatrix[HY];
            case "jw": return positionsMatrix[JW];
            case "kh": return positionsMatrix[KH];
            case "kk": return positionsMatrix[KK];
            case "kl": return positionsMatrix[KL];
            case "kn": return positionsMatrix[KN];
            case "kr": return positionsMatrix[KR];
            case "ks": return positionsMatrix[KS];
            case "ky": return positionsMatrix[KY];
            case "lb": return positionsMatrix[LB];
            case "lc": return positionsMatrix[LC];
            case "ld": return positionsMatrix[LD];
            case "lf": return positionsMatrix[LF];
            case "lg": return positionsMatrix[LG];
            case "lk": return positionsMatrix[LK];
            case "ll": return positionsMatrix[LL];
            case "lm": return positionsMatrix[LM];
            case "ls": return positionsMatrix[LS];
            case "lt": return positionsMatrix[LT];
            case "lw": return positionsMatrix[LW];
            case "ly": return positionsMatrix[LY];
            case "lz": return positionsMatrix[LZ];
            case "mb": return positionsMatrix[MB];
            case "my": return positionsMatrix[MY];
            case "nb": return positionsMatrix[NB];
            case "nc": return positionsMatrix[NC];
            case "nd": return positionsMatrix[ND];
            case "nf": return positionsMatrix[NF];
            case "ng": return positionsMatrix[NG];
            case "nk": return positionsMatrix[NK];
            case "nn": return positionsMatrix[NN];
            case "np": return positionsMatrix[NP];
            case "nq": return positionsMatrix[NQ];
            case "ns": return positionsMatrix[NS];
            case "nt": return positionsMatrix[NT];
            case "nx": return positionsMatrix[NX];
            case "ny": return positionsMatrix[NY];
            case "nz": return positionsMatrix[NZ];
            case "ph": return positionsMatrix[PH];
            case "pl": return positionsMatrix[PL];
            case "pn": return positionsMatrix[PN];
            case "pp": return positionsMatrix[PP];
            case "pr": return positionsMatrix[PR];
            case "ps": return positionsMatrix[PS];
            case "pt": return positionsMatrix[PT];
            case "px": return positionsMatrix[PX];
            case "py": return positionsMatrix[PY];
            case "rb": return positionsMatrix[RB];
            case "rc": return positionsMatrix[RC];
            case "rd": return positionsMatrix[RD];
            case "rf": return positionsMatrix[RF];
            case "rg": return positionsMatrix[RG];
            case "rj": return positionsMatrix[RJ];
            case "rk": return positionsMatrix[RK];
            case "rl": return positionsMatrix[RL];
            case "rm": return positionsMatrix[RM];
            case "rn": return positionsMatrix[RN];
            case "rp": return positionsMatrix[RP];
            case "rq": return positionsMatrix[RQ];
            case "rr": return positionsMatrix[RR];
            case "rs": return positionsMatrix[RS];
            case "rt": return positionsMatrix[RT];
            case "rv": return positionsMatrix[RV];
            case "ry": return positionsMatrix[RY];
            case "rz": return positionsMatrix[RZ];
            case "sb": return positionsMatrix[SB];
            case "sc": return positionsMatrix[SC];
            case "sg": return positionsMatrix[SG];
            case "sh": return positionsMatrix[SH];
            case "sk": return positionsMatrix[SK];
            case "sl": return positionsMatrix[SL];
            case "sm": return positionsMatrix[SM];
            case "sn": return positionsMatrix[SN];
            case "sp": return positionsMatrix[SP];
            case "sq": return positionsMatrix[SQ];
            case "ss": return positionsMatrix[SS];
            case "st": return positionsMatrix[ST];
            case "sv": return positionsMatrix[SV];
            case "sw": return positionsMatrix[SW];
            case "sy": return positionsMatrix[SY];
            case "th": return positionsMatrix[TH];
            case "tl": return positionsMatrix[TL];
            case "tr": return positionsMatrix[TR];
            case "ts": return positionsMatrix[TS];
            case "tt": return positionsMatrix[TT];
            case "tw": return positionsMatrix[TW];
            case "ty": return positionsMatrix[TY];
            case "tz": return positionsMatrix[TZ];
            case "vl": return positionsMatrix[VL];
            case "vn": return positionsMatrix[VN];
            case "vr": return positionsMatrix[VR];
            case "vs": return positionsMatrix[VS];
            case "vv": return positionsMatrix[VV];
            case "vy": return positionsMatrix[VY];
            case "vz": return positionsMatrix[VZ];
            case "wc": return positionsMatrix[WC];
            case "wg": return positionsMatrix[WG];
            case "wk": return positionsMatrix[WK];
            case "wm": return positionsMatrix[WM];
            case "wt": return positionsMatrix[WT];
            case "wx": return positionsMatrix[WX];
            case "xt": return positionsMatrix[XT];
            case "xx": return positionsMatrix[XX];
            case "yb": return positionsMatrix[YB];
            case "yd": return positionsMatrix[YD];
            case "yl": return positionsMatrix[YL];
            case "ym": return positionsMatrix[YM];
            case "yp": return positionsMatrix[YP];
            case "yr": return positionsMatrix[YR];
            case "ys": return positionsMatrix[YS];
            case "yt": return positionsMatrix[YT];
            case "yv": return positionsMatrix[YV];
            case "yz": return positionsMatrix[YZ];
            case "zb": return positionsMatrix[ZB];
            case "zc": return positionsMatrix[ZC];
            case "zd": return positionsMatrix[ZD];
            case "zf": return positionsMatrix[ZF];
            case "zg": return positionsMatrix[ZG];
            case "zk": return positionsMatrix[ZK];
            case "zn": return positionsMatrix[ZN];
            case "zy": return positionsMatrix[ZY];
            case "zz": return positionsMatrix[ZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    /**
     * Initializes the matrix that contains all positions about
     * double consonant tokens.
     * */
    private void initPositionsMatrix() {
        this.positionsMatrix =
            new boolean[getCollectionSize()][NUMBER_OF_POSITIONS];
        positionsMatrix[BB] = new boolean[] {false,true,false};
        positionsMatrix[BH] = new boolean[] {true,true,false};
        positionsMatrix[BL] = new boolean[] {true,true,false};
        positionsMatrix[BR] = new boolean[] {true,true,false};
        positionsMatrix[BS] = new boolean[] {true,true,true};
        positionsMatrix[BY] = new boolean[] {true,true,true};
        positionsMatrix[BZ] = new boolean[] {true,true,true};
        positionsMatrix[CC] = new boolean[] {false,true,false};
        positionsMatrix[CH] = new boolean[] {true,true,false};
        positionsMatrix[CL] = new boolean[] {true,true,false};
        positionsMatrix[CR] = new boolean[] {true,true,false};
        positionsMatrix[DD] = new boolean[] {false,true,false};
        positionsMatrix[DG] = new boolean[] {false,true,false};
        positionsMatrix[DH] = new boolean[] {true,true,false};
        positionsMatrix[DK] = new boolean[] {false,true,false};
        positionsMatrix[DM] = new boolean[] {false,true,false};
        positionsMatrix[DR] = new boolean[] {true,true,false};
        positionsMatrix[DS] = new boolean[] {true,true,true};
        positionsMatrix[DW] = new boolean[] {true,true,true};
        positionsMatrix[DY] = new boolean[] {true,true,true};
        positionsMatrix[FF] = new boolean[] {false,true,false};
        positionsMatrix[FL] = new boolean[] {true,true,false};
        positionsMatrix[FN] = new boolean[] {false,true,true};
        positionsMatrix[FR] = new boolean[] {true,true,false};
        positionsMatrix[FS] = new boolean[] {true,true,true};
        positionsMatrix[FZ] = new boolean[] {true,true,true};
        positionsMatrix[GG] = new boolean[] {false,true,false};
        positionsMatrix[GH] = new boolean[] {true,true,false};
        positionsMatrix[GL] = new boolean[] {true,true,true};
        positionsMatrix[GM] = new boolean[] {false,true,false};
        positionsMatrix[GR] = new boolean[] {true,true,true};
        positionsMatrix[HW] = new boolean[] {true,false,false};
        positionsMatrix[HY] = new boolean[] {true,false,false};
        positionsMatrix[JW] = new boolean[] {true,true,true};
        positionsMatrix[KH] = new boolean[] {true,true,false};
        positionsMatrix[KK] = new boolean[] {false,true,false};
        positionsMatrix[KL] = new boolean[] {true,true,false};
        positionsMatrix[KN] = new boolean[] {false,true,false};
        positionsMatrix[KR] = new boolean[] {true,true,false};
        positionsMatrix[KS] = new boolean[] {false,true,true};
        positionsMatrix[KY] = new boolean[] {true,true,true};
        positionsMatrix[LB] = new boolean[] {false,true,true};
        positionsMatrix[LC] = new boolean[] {false,true,true};
        positionsMatrix[LD] = new boolean[] {false,true,true};
        positionsMatrix[LF] = new boolean[] {false,true,true};
        positionsMatrix[LG] = new boolean[] {false,true,false};
        positionsMatrix[LK] = new boolean[] {false,true,false};
        positionsMatrix[LL] = new boolean[] {false,true,true};
        positionsMatrix[LM] = new boolean[] {false,true,false};
        positionsMatrix[LS] = new boolean[] {false,true,true};
        positionsMatrix[LT] = new boolean[] {false,true,true};
        positionsMatrix[LW] = new boolean[] {true,true,true};
        positionsMatrix[LY] = new boolean[] {true,true,true};
        positionsMatrix[LZ] = new boolean[] {false,true,true};
        positionsMatrix[MB] = new boolean[] {false,true,false};
        positionsMatrix[MY] = new boolean[] {true,true,true};
        positionsMatrix[NB] = new boolean[] {false,true,false};
        positionsMatrix[NC] = new boolean[] {false,true,false};
        positionsMatrix[ND] = new boolean[] {false,true,true};
        positionsMatrix[NF] = new boolean[] {false,true,false};
        positionsMatrix[NG] = new boolean[] {false,true,true};
        positionsMatrix[NK] = new boolean[] {false,true,true};
        positionsMatrix[NN] = new boolean[] {false,true,false};
        positionsMatrix[NP] = new boolean[] {false,true,false};
        positionsMatrix[NQ] = new boolean[] {false,true,false};
        positionsMatrix[NS] = new boolean[] {false,true,true};
        positionsMatrix[NT] = new boolean[] {false,true,true};
        positionsMatrix[NX] = new boolean[] {false,true,true};
        positionsMatrix[NY] = new boolean[] {true,true,true};
        positionsMatrix[NZ] = new boolean[] {false,true,true};
        positionsMatrix[PH] = new boolean[] {true,true,false};
        positionsMatrix[PL] = new boolean[] {true,true,false};
        positionsMatrix[PN] = new boolean[] {false,true,true};
        positionsMatrix[PP] = new boolean[] {false,true,false};
        positionsMatrix[PR] = new boolean[] {true,true,true};
        positionsMatrix[PS] = new boolean[] {true,true,true};
        positionsMatrix[PT] = new boolean[] {false,true,true};
        positionsMatrix[PX] = new boolean[] {false,true,true};
        positionsMatrix[PY] = new boolean[] {true,true,true};
        positionsMatrix[RB] = new boolean[] {false,true,true};
        positionsMatrix[RC] = new boolean[] {false,true,true};
        positionsMatrix[RD] = new boolean[] {false,true,true};
        positionsMatrix[RF] = new boolean[] {false,true,true};
        positionsMatrix[RG] = new boolean[] {false,true,true};
        positionsMatrix[RJ] = new boolean[] {false,true,false};
        positionsMatrix[RK] = new boolean[] {false,true,true};
        positionsMatrix[RL] = new boolean[] {false,true,false};
        positionsMatrix[RM] = new boolean[] {false,true,true};
        positionsMatrix[RN] = new boolean[] {false,true,true};
        positionsMatrix[RP] = new boolean[] {false,true,true};
        positionsMatrix[RQ] = new boolean[] {false,true,false};
        positionsMatrix[RR] = new boolean[] {false,true,false};
        positionsMatrix[RS] = new boolean[] {false,true,true};
        positionsMatrix[RT] = new boolean[] {false,true,true};
        positionsMatrix[RV] = new boolean[] {false,true,true};
        positionsMatrix[RY] = new boolean[] {true,true,true};
        positionsMatrix[RZ] = new boolean[] {false,true,true};
        positionsMatrix[SB] = new boolean[] {false,true,false};
        positionsMatrix[SC] = new boolean[] {false,true,true};
        positionsMatrix[SG] = new boolean[] {false,true,false};
        positionsMatrix[SH] = new boolean[] {true,true,true};
        positionsMatrix[SK] = new boolean[] {true,true,true};
        positionsMatrix[SL] = new boolean[] {true,true,false};
        positionsMatrix[SM] = new boolean[] {true,true,false};
        positionsMatrix[SN] = new boolean[] {true,true,false};
        positionsMatrix[SP] = new boolean[] {true,true,false};
        positionsMatrix[SQ] = new boolean[] {true,true,false};
        positionsMatrix[SS] = new boolean[] {false,true,false};
        positionsMatrix[ST] = new boolean[] {true,true,true};
        positionsMatrix[SV] = new boolean[] {true,true,false};
        positionsMatrix[SW] = new boolean[] {true,true,true};
        positionsMatrix[SY] = new boolean[] {true,true,true};
        positionsMatrix[TH] = new boolean[] {true,true,false};
        positionsMatrix[TL] = new boolean[] {true,true,false};
        positionsMatrix[TR] = new boolean[] {true,true,true};
        positionsMatrix[TS] = new boolean[] {false,true,true};
        positionsMatrix[TT] = new boolean[] {false,true,false};
        positionsMatrix[TW] = new boolean[] {true,true,true};
        positionsMatrix[TY] = new boolean[] {true,true,true};
        positionsMatrix[TZ] = new boolean[] {false,true,true};
        positionsMatrix[VL] = new boolean[] {true,true,false};
        positionsMatrix[VN] = new boolean[] {false,true,false};
        positionsMatrix[VR] = new boolean[] {true,true,true};
        positionsMatrix[VS] = new boolean[] {false,true,true};
        positionsMatrix[VV] = new boolean[] {false,true,false};
        positionsMatrix[VY] = new boolean[] {true,true,true};
        positionsMatrix[VZ] = new boolean[] {false,true,true};
        positionsMatrix[WC] = new boolean[] {true,true,false};
        positionsMatrix[WG] = new boolean[] {true,true,false};
        positionsMatrix[WK] = new boolean[] {true,true,false};
        positionsMatrix[WM] = new boolean[] {true,true,false};
        positionsMatrix[WT] = new boolean[] {true,true,false};
        positionsMatrix[WX] = new boolean[] {true,true,false};
        positionsMatrix[XT] = new boolean[] {false,true,false};
        positionsMatrix[XX] = new boolean[] {false,true,false};
        positionsMatrix[YB] = new boolean[] {true,true,false};
        positionsMatrix[YD] = new boolean[] {true,true,false};
        positionsMatrix[YL] = new boolean[] {true,true,true};
        positionsMatrix[YM] = new boolean[] {true,true,false};
        positionsMatrix[YP] = new boolean[] {true,true,true};
        positionsMatrix[YR] = new boolean[] {true,true,false};
        positionsMatrix[YS] = new boolean[] {true,true,true};
        positionsMatrix[YT] = new boolean[] {true,true,false};
        positionsMatrix[YV] = new boolean[] {true,true,false};
        positionsMatrix[YZ] = new boolean[] {true,true,true};
        positionsMatrix[ZB] = new boolean[] {false,true,false};
        positionsMatrix[ZC] = new boolean[] {false,true,false};
        positionsMatrix[ZD] = new boolean[] {false,true,false};
        positionsMatrix[ZF] = new boolean[] {false,true,false};
        positionsMatrix[ZG] = new boolean[] {false,true,false};
        positionsMatrix[ZK] = new boolean[] {true,true,false};
        positionsMatrix[ZN] = new boolean[] {true,true,false};
        positionsMatrix[ZY] = new boolean[] {true,true,true};
        positionsMatrix[ZZ] = new boolean[] {false,true,false};
    }

}
