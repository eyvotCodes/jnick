package com.example.jnick.discriminator;

/**
 * @author fabian
 */
public class TripleConsonantDiscriminator extends Discriminator {

    private boolean[][]
        positionsMatrixForB, positionsMatrixForC, positionsMatrixForD,
        positionsMatrixForF, positionsMatrixForG, positionsMatrixForH,
        positionsMatrixForJ, positionsMatrixForK, positionsMatrixForL,
        positionsMatrixForM, positionsMatrixForN, positionsMatrixForP,
        positionsMatrixForR, positionsMatrixForS, positionsMatrixForT,
        positionsMatrixForV, positionsMatrixForW, positionsMatrixForX,
        positionsMatrixForY, positionsMatrixForZ;

    private final short
        BBR =   0, BBS =   1, BBY =   2, BLW =   3, BLY =   4, BRY =   5,
        BSY =   6, BYB =   7, BYL =   8, BYM =   9, BYP =  10, BYR =  11,
        BYS =  12, BYT =  13, BYV =  14, BYZ =  15, BZY =  16, CCL =  17,
        CCR =  18, CRY =  19, DDR =  20, DDS =  21, DDY =  22, DGG =  23,
        DGH =  24, DGL =  25, DGR =  26, DKH =  27, DKK =  28, DKL =  29,
        DKR =  30, DKY =  31, DMY =  32, DRY =  33, DSH =  34, DWC =  35,
        DWG =  36, DWK =  37, DWM =  38, DWT =  39, DWX =  40, DYB =  41,
        DYL =  42, DYM =  43, DYP =  44, DYR =  45, DYS =  46, DYT =  47,
        DYV =  48, DYZ =  49, FFL =  50, FFR =  51, FFS =  52, FFZ =  53,
        FLW =  54, FLY =  55, FLZ =  56, FNN =  57, FNS =  58, FNX =  59,
        FNY =  60, FNZ =  61, FRS =  62, FRY =  63, FRZ =  64, FSC =  65,
        FSG =  66, FSH =  67, FSK =  68, FSS =  69, FST =  70, FSW =  71,
        FSY =  72, FZK =  73, FZN =  74, FZY =  75, FZZ =  76, GGL =  77,
        GGR =  78, GLS =  79, GLW =  80, GLY =  81, GMY =  82, GRR =  83,
        GRS =  84, GRY =  85, HWC =  86, HWG =  87, HWK =  88, HWM =  89,
        HWT =  90, HWX =  91, HYB =  92, HYD =  93, HYL =  94, HYM =  95,
        HYP =  96, HYR =  97, HYS =  98, HYT =  99, HYV = 100, HYZ = 101,
        JWC = 102, JWG = 103, JWK = 104, JWM = 105, JWT = 106, JWX = 107,
        KKL = 108, KKR = 109, KKS = 110, KKY = 111, KLW = 112, KLY = 113,
        KNN = 114, KNS = 115, KNT = 116, KNY = 117, KNZ = 118, KRN = 119,
        KRS = 120, KRY = 121, KRZ = 122, KSG = 123, KSH = 124, KSM = 125,
        KSP = 126, KSS = 127, KST = 128, KSW = 129, KSY = 130, KYB = 131,
        KYL = 132, KYM = 133, KYP = 134, KYR = 135, KYS = 136, KYT = 137,
        KYV = 138, KYZ = 139, LBB = 140, LBH = 141, LBL = 142, LBR = 143,
        LBY = 144, LBZ = 145, LCH = 146, LCL = 147, LCR = 148, LDD = 149,
        LDH = 150, LDR = 151, LDS = 152, LDW = 153, LDY = 154, LFF = 155,
        LFL = 156, LFR = 157, LFS = 158, LFZ = 159, LGG = 160, LGH = 161,
        LGL = 162, LGR = 163, LKH = 164, LKK = 165, LKL = 166, LKR = 167,
        LKY = 168, LLW = 169, LLY = 170, LMY = 171, LSC = 172, LSH = 173,
        LSN = 174, LSS = 175, LSW = 176, LSY = 177, LTH = 178, LTR = 179,
        LTT = 180, LTW = 181, LTY = 182, LTZ = 183, LWC = 184, LWG = 185,
        LWK = 186, LWM = 187, LWT = 188, LWX = 189, LYB = 190, LYL = 191,
        LYM = 192, LYP = 193, LYR = 194, LYS = 195, LYT = 196, LYV = 197,
        LYZ = 198, LZY = 199, LZZ = 200, MBB = 201, MBH = 202, MBL = 203,
        MBR = 204, MBY = 205, MYB = 206, MYL = 207, MYM = 208, MYP = 209,
        MYR = 210, MYS = 211, MYT = 212, MYV = 213, MYZ = 214, NBB = 215,
        NBH = 216, NBL = 217, NBR = 218, NBY = 219, NBZ = 220, NCH = 221,
        NCL = 222, NCR = 223, NDD = 224, NDH = 225, NDR = 226, NDS = 227,
        NDW = 228, NDY = 229, NFF = 230, NFL = 231, NFR = 232, NFS = 233,
        NFZ = 234, NGG = 235, NGH = 236, NGL = 237, NGR = 238, NKH = 239,
        NKK = 240, NKL = 241, NKR = 242, NKS = 243, NKY = 244, NNB = 245,
        NNC = 246, NND = 247, NNF = 248, NNG = 249, NNK = 250, NNP = 251,
        NNQ = 252, NNS = 253, NNT = 254, NNY = 255, NNZ = 256, NPH = 257,
        NPL = 258, NPP = 259, NPR = 260, NPS = 261, NPY = 262, NSH = 263,
        NSS = 264, NSW = 265, NSY = 266, NTH = 267, NTR = 268, NTT = 269,
        NTW = 270, NTY = 271, NTZ = 272, NXX = 273, NYB = 274, NYL = 275,
        NYM = 276, NYP = 277, NYR = 278, NYS = 279, NYT = 280, NYV = 281,
        NYZ = 282, NZY = 283, NZZ = 284, PLW = 285, PLY = 286, PNY = 287,
        PPL = 288, PPN = 289, PPR = 290, PPS = 291, PPT = 292, PPY = 293,
        PRS = 294, PRY = 295, PSH = 296, PSK = 297, PSN = 298, PSS = 299,
        PST = 300, PSY = 301, PTH = 302, PTR = 303, PTY = 304, PXX = 305,
        PYB = 306, PYL = 307, PYM = 308, PYP = 309, PYR = 310, PYS = 311,
        PYT = 312, PYV = 313, PYZ = 314, RBB = 315, RBH = 316, RBL = 317,
        RBR = 318, RBY = 319, RCH = 320, RCL = 321, RDD = 322, RDH = 323,
        RDS = 324, RDW = 325, RDY = 326, RFF = 327, RFL = 328, RFR = 329,
        RFS = 330, RFZ = 331, RGG = 332, RGH = 333, RGL = 334, RJW = 335,
        RKH = 336, RKK = 337, RKL = 338, RKN = 339, RKS = 340, RKY = 341,
        RLW = 342, RLY = 343, RMY = 344, RNX = 345, RNY = 346, RNZ = 347,
        RPH = 348, RPL = 349, RPN = 350, RPP = 351, RPS = 352, RPY = 353,
        RRY = 354, RSH = 355, RSS = 356, RSW = 357, RSY = 358, RTH = 359,
        RTS = 360, RTT = 361, RTW = 362, RTY = 363, RTZ = 364, RVL = 365,
        RVN = 366, RVS = 367, RVV = 368, RVY = 369, RVZ = 370, RYB = 371,
        RYL = 372, RYM = 373, RYP = 374, RYR = 375, RYS = 376, RYT = 377,
        RYV = 378, RYZ = 379, RZG = 380, RZY = 381, RZZ = 382, SBB = 383,
        SBH = 384, SBR = 385, SBY = 386, SCH = 387, SCL = 388, SCR = 389,
        SGG = 390, SGH = 391, SGL = 392, SGR = 393, SKH = 394, SKK = 395,
        SKL = 396, SKR = 397, SKY = 398, SMY = 399, SNN = 400, SNY = 401,
        SPH = 402, SPL = 403, SPP = 404, SPR = 405, SPY = 406, SSB = 407,
        SSG = 408, SSK = 409, SSN = 410, SSP = 411, SST = 412, SSW = 413,
        STH = 414, STL = 415, STR = 416, STT = 417, STW = 418, STY = 419,
        SVL = 420, SVR = 421, SVV = 422, SVY = 423, SWB = 424, SWG = 425,
        SWK = 426, SWM = 427, SWT = 428, SWX = 429, SYB = 430, SYL = 431,
        SYM = 432, SYP = 433, SYR = 434, SYS = 435, SYT = 436, SYV = 437,
        SYZ = 438, TRS = 439, TRY = 440, TRZ = 441, TSB = 442, TSG = 443,
        TSH = 444, TSN = 445, TSS = 446, TSV = 447, TSW = 448, TSY = 449,
        TTW = 450, TTY = 451, TWC = 452, TWG = 453, TWK = 454, TWM = 455,
        TWT = 456, TWX = 457, TYB = 458, TYL = 459, TYM = 460, TYP = 461,
        TYR = 462, TYS = 463, TYT = 464, TYV = 465, TYZ = 466, TZC = 467,
        TZD = 468, TZF = 469, TZG = 470, TZK = 471, TZN = 472, TZY = 473,
        TZZ = 474, VLS = 475, VLY = 476, VNN = 477, VNS = 478, VNX = 479,
        VNY = 480, VRS = 481, VRY = 482, VRZ = 483, VSC = 484, VSH = 485,
        VSK = 486, VSL = 487, VSN = 488, VSS = 489, VST = 490, VSW = 491,
        VSY = 492, VVY = 493, VYB = 494, VYL = 495, VYM = 496, VYP = 497,
        VYR = 498, VYS = 499, VYT = 500, VYV = 501, VYZ = 502, VZC = 503,
        VZG = 504, VZY = 505, VZZ = 506, WCC = 507, WCH = 508, WCL = 509,
        WCR = 510, WGG = 511, WGH = 512, WGL = 513, WGM = 514, WGR = 515,
        WKH = 516, WKK = 517, WKL = 518, WKN = 519, WKR = 520, WKS = 521,
        WKY = 522, WMB = 523, WMY = 524, WTH = 525, WTL = 526, WTR = 527,
        WTS = 528, WTT = 529, WTW = 530, WTY = 531, WTZ = 532, WXT = 533,
        WXX = 534, XTH = 535, XTR = 536, XTT = 537, XTW = 538, XTY = 539,
        YBB = 540, YBH = 541, YBL = 542, YBR = 543, YBS = 544, YBY = 545,
        YBZ = 546, YDD = 547, YDG = 548, YDH = 549, YDK = 550, YDM = 551,
        YDR = 552, YDS = 553, YDW = 554, YDY = 555, YLB = 556, YLC = 557,
        YLD = 558, YLF = 559, YLG = 560, YLK = 561, YLL = 562, YLM = 563,
        YLS = 564, YLT = 565, YLW = 566, YLY = 567, YLZ = 568, YMB = 569,
        YMY = 570, YPH = 571, YPL = 572, YPB = 573, YPP = 574, YPR = 575,
        YPS = 576, YPT = 577, YPX = 578, YPY = 579, YRB = 580, YRC = 581,
        YRD = 582, YRF = 583, YRG = 584, YRJ = 585, YRK = 586, YRL = 587,
        YRM = 588, YRN = 589, YRP = 590, YRQ = 591, YRR = 592, YRS = 593,
        YRT = 594, YRV = 595, YRY = 596, YRZ = 597, YSB = 598, YSC = 599,
        YSG = 600, YSH = 601, YSK = 602, YSL = 603, YSM = 604, YSN = 605,
        YSP = 606, YSQ = 607, YSS = 608, YST = 609, YSV = 610, YSW = 611,
        YSY = 612, YTH = 613, YTL = 614, YTR = 615, YTS = 616, YTT = 617,
        YTW = 618, YTY = 619, YTZ = 620, YVL = 621, YVN = 622, YVR = 623,
        YVS = 624, YVV = 625, YVY = 626, YVZ = 627, YZB = 628, YZC = 629,
        YZD = 630, YZF = 631, YZG = 632, YZK = 633, YZN = 634, YZY = 635,
        YZZ = 636, ZBB = 637, ZBH = 638, ZBR = 639, ZBY = 640, ZCH = 641,
        ZCL = 642, ZDD = 643, ZDH = 644, ZDR = 645, ZDW = 646, ZDY = 647,
        ZFF = 648, ZFL = 649, ZFR = 650, ZGG = 651, ZGH = 652, ZGL = 653,
        ZGR = 654, ZKH = 655, ZKK = 656, ZKL = 657, ZKR = 658, ZKY = 659,
        ZNN = 660, ZNY = 661, ZYB = 662, ZYL = 663, ZYM = 664, ZYP = 665,
        ZYR = 666, ZYS = 667, ZYT = 668, ZYV = 669, ZYZ = 670, ZZY = 671;

    private final String
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_B
            = "bbr-bbs-bby-"
            + "blw-bly-"
            + "bry-"
            + "bsy-"
            + "byb-byl-bym-byp-byr-bys-byt-byv-byz-"
            + "bzy",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_C
            = "ccl-ccr-"
            + "cry",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_D
            = "ddr-dds-ddy-"
            + "dgg-dgh-dgl-dgr-"
            + "dkh-dkk-dkl-dkr-dky-"
            + "dmy-"
            + "dry-"
            + "dsh-"
            + "dwc-dwg-dwk-dwm-dwt-dwx-"
            + "dyb-dyl-dym-dyp-dyr-dys-dyt-dyv-dyz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_F
            = "ffl-ffr-ffs-ffz-"
            + "flw-fly-flz-"
            + "fnn-fns-fnx-fny-fnz-"
            + "frs-fry-frz-"
            + "fsc-fsg-fsh-fsk-fss-fst-fsw-fsy-"
            + "fzk-fzn-fzy-fzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_G
            = "ggl-ggr-"
            + "gls-glw-gly-"
            + "gmy-"
            + "grr-grs-gry",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_H
            = "hwc-hwg-hwk-hwm-hwt-hwx-"
            + "hyb-hyd-hyl-hym-hyp-hyr-hys-hyt-hyv-hyz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_J
            = "jwc-jwg-jwk-jwm-jwt-jwx",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_K
            = "kkl-kkr-kks-kky-"
            + "klw-kly-"
            + "knn-kns-knt-kny-knz-"
            + "krn-krs-kry-krz-"
            + "ksg-ksh-ksm-ksp-kss-kst-ksw-ksy-"
            + "kyb-kyl-kym-kyp-kyr-kys-kyt-kyv-kyz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_L
            = "lbb-lbh-lbl-lbr-lby-lbz-"
            + "lch-lcl-lcr-"
            + "ldd-ldh-ldr-lds-ldw-ldy-"
            + "lff-lfl-lfr-lfs-lfz-"
            + "lgg-lgh-lgl-lgr-"
            + "lkh-lkk-lkl-lkr-lky-"
            + "llw-lly-"
            + "lmy-"
            + "lsc-lsh-lsn-lss-lsw-lsy-"
            + "lth-ltr-ltt-ltw-lty-ltz-"
            + "lwc-lwg-lwk-lwm-lwt-lwx-"
            + "lyb-lyl-lym-lyp-lyr-lys-lyt-lyv-lyz-"
            + "lzy-lzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_M
            = "mbb-mbh-mbl-mbr-mby-"
            + "myb-myl-mym-myp-myr-mys-myt-myv-myz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_N
            = "nbb-nbh-nbl-nbr-nby-nbz-"
            + "nch-ncl-ncr-"
            + "ndd-ndh-ndr-nds-ndw-ndy-"
            + "nff-nfl-nfr-nfs-nfz-"
            + "ngg-ngh-ngl-ngr-"
            + "nkh-nkk-nkl-nkr-nks-nky-"
            + "nnb-nnc-nnd-nnf-nng-nnk-nnp-nnq-nns-nnt-nny-nnz-"
            + "nph-npl-npp-npr-nps-npy-"
            + "nsh-nss-nsw-nsy-"
            + "nth-ntr-ntt-ntw-nty-ntz-"
            + "nxx-"
            + "nyb-nyl-nym-nyp-nyr-nys-nyt-nyv-nyz-"
            + "nzy-nzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_P
            = "plw-ply-"
            + "pny-"
            + "ppl-ppn-ppr-pps-ppt-ppy-"
            + "prs-pry-"
            + "psh-psk-psn-pss-pst-psy-"
            + "pth-ptr-pty-"
            + "pxx-"
            + "pyb-pyl-pym-pyp-pyr-pys-pyt-pyv-pyz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_R
            = "rbb-rbh-rbl-rbr-rby-"
            + "rch-rcl-"
            + "rdd-rdh-rds-rdw-rdy-"
            + "rff-rfl-rfr-rfs-rfz-"
            + "rgg-rgh-rgl-"
            + "rjw-"
            + "rkh-rkk-rkl-rkn-rks-rky-"
            + "rlw-rly-"
            + "rmy-"
            + "rnx-rny-rnz-"
            + "rph-rpl-rpn-rpp-rps-rpy-"
            + "rry-"
            + "rsh-rss-rsw-rsy-"
            + "rth-rts-rtt-rtw-rty-rtz-"
            + "rvl-rvn-rvs-rvv-rvy-rvz-"
            + "ryb-ryl-rym-ryp-ryr-rys-ryt-ryv-ryz-"
            + "rzg-rzy-rzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_S
            = "sbb-sbh-sbr-sby-"
            + "sch-scl-scr-"
            + "sgg-sgh-sgl-sgr-"
            + "skh-skk-skl-skr-sky-"
            + "smy-"
            + "snn-sny-"
            + "sph-spl-spp-spr-spy-"
            + "ssb-ssg-ssk-ssn-ssp-sst-ssw-"
            + "sth-stl-str-stt-stw-sty-"
            + "svl-svr-svv-svy-"
            + "swb-swg-swk-swm-swt-swx-"
            + "syb-syl-sym-syp-syr-sys-syt-syv-syz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_T
            = "trs-try-trz-"
            + "tsb-tsg-tsh-tsn-tss-tsv-tsw-tsy-"
            + "ttw-tty-"
            + "twc-twg-twk-twm-twt-twx-"
            + "tyb-tyl-tym-typ-tyr-tys-tyt-tyv-tyz-"
            + "tzc-tzd-tzf-tzg-tzk-tzn-tzy-tzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_V
            = "vls-vly-"
            + "vnn-vns-vnx-vny-"
            + "vrs-vry-vrz-"
            + "vsc-vsh-vsk-vsl-vsn-vss-vst-vsw-vsy-"
            + "vvy-"
            + "vyb-vyl-vym-vyp-vyr-vys-vyt-vyv-vyz-"
            + "vzc-vzg-vzy-vzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_W
            = "wcc-wch-wcl-wcr-"
            + "wgg-wgh-wgl-wgm-wgr-"
            + "wkh-wkk-wkl-wkn-wkr-wks-wky-"
            + "wmb-wmy-"
            + "wth-wtl-wtr-wts-wtt-wtw-wty-wtz-"
            + "wxt-wxx",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_X
            = "xth-xtr-xtt-xtw-xty",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_Y
            = "ybb-ybh-ybl-ybr-ybs-yby-ybz-"
            + "ydd-ydg-ydh-ydk-ydm-ydr-yds-ydw-ydy-"
            + "ylb-ylc-yld-ylf-ylg-ylk-yll-ylm-yls-ylt-ylw-yly-ylz-"
            + "ymb-ymy-"
            + "yph-ypl-ypb-ypp-ypr-yps-ypt-ypx-ypy-"
            + "yrb-yrc-yrd-yrf-yrg-yrj-yrk-yrl-yrm-"
            + "yrn-yrp-yrq-yrr-yrs-yrt-yrv-yry-yrz-"
            + "ysb-ysc-ysg-ysh-ysk-ysl-ysm-ysn-ysp-ysq-yss-yst-ysv-ysw-ysy-"
            + "yth-ytl-ytr-yts-ytt-ytw-yty-ytz-"
            + "yvl-yvn-yvr-yvs-yvv-yvy-yvz-"
            + "yzb-yzc-yzd-yzf-yzg-yzk-yzn-yzy-yzz",
        TRIPLE_CONSONANTS_THAT_STARTS_WITH_Z
            = "zbb-zbh-zbr-zby-"
            + "zch-zcl-"
            + "zdd-zdh-zdr-zdw-zdy-"
            + "zff-zfl-zfr-"
            + "zgg-zgh-zgl-zgr-"
            + "zkh-zkk-zkl-zkr-zky-"
            + "znn-zny-"
            + "zyb-zyl-zym-zyp-zyr-zys-zyt-zyv-zyz-"
            + "zzy",
        NO_CONSONANTS
            = "";


    public TripleConsonantDiscriminator() {
        initPositionsMatrix();
    }


    /**
     * {@inheritDoc}
     * */
    @Override public boolean isValid(String tripleCharacter) {
        char firstCharacter = getFirstCharacter(tripleCharacter);
        for(String tripleConsonant:getTripleConsonants(firstCharacter)
            .split(CHARACTER_SEPARATOR)) {
            if(tripleCharacter.equals(tripleConsonant)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public short getCollectionSize() {
        return (short) (
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_B + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_C + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_D + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_F + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_G + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_H + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_J + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_K + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_L + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_M + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_N + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_P + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_R + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_S + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_T + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_V + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_W + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_X + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_Y + "-" +
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_Z
        )
        .split(CHARACTER_SEPARATOR)
        .length;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public boolean[] getValidPositions(String tripleConsonant) {
        char firstCharacter = getFirstCharacter(tripleConsonant);
        switch(firstCharacter) {
            case 'b': return getValidPositionsForB(tripleConsonant);
            case 'c': return getValidPositionsForC(tripleConsonant);
            case 'd': return getValidPositionsForD(tripleConsonant);
            case 'f': return getValidPositionsForF(tripleConsonant);
            case 'g': return getValidPositionsForG(tripleConsonant);
            case 'h': return getValidPositionsForH(tripleConsonant);
            case 'J': return getValidPositionsForJ(tripleConsonant);
            case 'k': return getValidPositionsForK(tripleConsonant);
            case 'l': return getValidPositionsForL(tripleConsonant);
            case 'm': return getValidPositionsForM(tripleConsonant);
            case 'n': return getValidPositionsForN(tripleConsonant);
            case 'p': return getValidPositionsForP(tripleConsonant);
            case 'r': return getValidPositionsForR(tripleConsonant);
            case 's': return getValidPositionsForS(tripleConsonant);
            case 't': return getValidPositionsForT(tripleConsonant);
            case 'v': return getValidPositionsForV(tripleConsonant);
            case 'w': return getValidPositionsForW(tripleConsonant);
            case 'x': return getValidPositionsForX(tripleConsonant);
            case 'y': return getValidPositionsForY(tripleConsonant);
            case 'z': return getValidPositionsForZ(tripleConsonant);
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    /*
     * getCollectionSize() subMethods
     * */

    private short getCollectionSizeForB() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_B
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForC() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_C
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForD() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_D
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForF() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_F
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForG() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_G
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForH() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_H
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForJ() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_J
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForK() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_K
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForL() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_L
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForM() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_M
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForN() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_N
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForP() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_P
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForR() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_R
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForS() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_S
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForT() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_T
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForV() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_V
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForW() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_W
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForX() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_X
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForY() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_Y
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    private short getCollectionSizeForZ() {
        return (short)
            TRIPLE_CONSONANTS_THAT_STARTS_WITH_Z
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    /*
     * getValidPositions() subMethods
     * */

    private boolean[] getValidPositionsForB(String tripleConsonant) {
        switch(tripleConsonant) {
            case "bbr": return positionsMatrixForB[BBR];
            case "bbs": return positionsMatrixForB[BBS];
            case "bby": return positionsMatrixForB[BBY];
            case "blw": return positionsMatrixForB[BLW];
            case "bly": return positionsMatrixForB[BLY];
            case "bry": return positionsMatrixForB[BRY];
            case "bsy": return positionsMatrixForB[BSY];
            case "byb": return positionsMatrixForB[BYB];
            case "byl": return positionsMatrixForB[BYL];
            case "bym": return positionsMatrixForB[BYM];
            case "byp": return positionsMatrixForB[BYP];
            case "byr": return positionsMatrixForB[BYR];
            case "bys": return positionsMatrixForB[BYS];
            case "byt": return positionsMatrixForB[BYT];
            case "byv": return positionsMatrixForB[BYV];
            case "byz": return positionsMatrixForB[BYZ];
            case "bzy": return positionsMatrixForB[BZY];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForC(String tripleConsonant) {
        switch(tripleConsonant) {
            case "ccl": return positionsMatrixForC[CCL];
            case "ccr": return positionsMatrixForC[CCR];
            case "cry": return positionsMatrixForC[CRY];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForD(String tripleConsonant) {
        switch(tripleConsonant) {
            case "ddr": return positionsMatrixForD[DDR];
            case "dds": return positionsMatrixForD[DDS];
            case "ddy": return positionsMatrixForD[DDY];
            case "dgg": return positionsMatrixForD[DGG];
            case "dgh": return positionsMatrixForD[DGH];
            case "dgl": return positionsMatrixForD[DGL];
            case "dgr": return positionsMatrixForD[DGR];
            case "dkh": return positionsMatrixForD[DKH];
            case "dkk": return positionsMatrixForD[DKK];
            case "dkl": return positionsMatrixForD[DKL];
            case "dkr": return positionsMatrixForD[DKR];
            case "dky": return positionsMatrixForD[DKY];
            case "dmy": return positionsMatrixForD[DMY];
            case "dry": return positionsMatrixForD[DRY];
            case "dsh": return positionsMatrixForD[DSH];
            case "dwc": return positionsMatrixForD[DWC];
            case "dwg": return positionsMatrixForD[DWG];
            case "dwk": return positionsMatrixForD[DWK];
            case "dwm": return positionsMatrixForD[DWM];
            case "dwt": return positionsMatrixForD[DWT];
            case "dwx": return positionsMatrixForD[DWX];
            case "dyb": return positionsMatrixForD[DYB];
            case "dyl": return positionsMatrixForD[DYL];
            case "dym": return positionsMatrixForD[DYM];
            case "dyp": return positionsMatrixForD[DYP];
            case "dyr": return positionsMatrixForD[DYR];
            case "dys": return positionsMatrixForD[DYS];
            case "dyt": return positionsMatrixForD[DYT];
            case "dyv": return positionsMatrixForD[DYV];
            case "dyz": return positionsMatrixForD[DYZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForF(String tripleConsonant) {
        switch(tripleConsonant) {
            case "ffl": return positionsMatrixForF[FFL];
            case "ffr": return positionsMatrixForF[FFR];
            case "ffs": return positionsMatrixForF[FFS];
            case "ffz": return positionsMatrixForF[FFZ];
            case "flw": return positionsMatrixForF[FLW];
            case "fly": return positionsMatrixForF[FLY];
            case "flz": return positionsMatrixForF[FLZ];
            case "fnn": return positionsMatrixForF[FNN];
            case "fns": return positionsMatrixForF[FNS];
            case "fnx": return positionsMatrixForF[FNX];
            case "fny": return positionsMatrixForF[FNY];
            case "fnz": return positionsMatrixForF[FNZ];
            case "frs": return positionsMatrixForF[FRS];
            case "fry": return positionsMatrixForF[FRY];
            case "frz": return positionsMatrixForF[FRZ];
            case "fsc": return positionsMatrixForF[FSC];
            case "fsg": return positionsMatrixForF[FSG];
            case "fsh": return positionsMatrixForF[FSH];
            case "fsk": return positionsMatrixForF[FSK];
            case "fss": return positionsMatrixForF[FSS];
            case "fst": return positionsMatrixForF[FST];
            case "fsw": return positionsMatrixForF[FSW];
            case "fsy": return positionsMatrixForF[FSY];
            case "fzk": return positionsMatrixForF[FZK];
            case "fzn": return positionsMatrixForF[FZN];
            case "fzy": return positionsMatrixForF[FZY];
            case "fzz": return positionsMatrixForF[FZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForG(String tripleConsonant) {
        switch(tripleConsonant) {
            case "ggl": return positionsMatrixForG[GGL];
            case "ggr": return positionsMatrixForG[GGR];
            case "gls": return positionsMatrixForG[GLS];
            case "glw": return positionsMatrixForG[GLW];
            case "gly": return positionsMatrixForG[GLY];
            case "gmy": return positionsMatrixForG[GMY];
            case "grr": return positionsMatrixForG[GRR];
            case "grs": return positionsMatrixForG[GRS];
            case "gry": return positionsMatrixForG[GRY];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForH(String tripleConsonant) {
        switch(tripleConsonant) {
            case "hwc": return positionsMatrixForH[HWC];
            case "hwg": return positionsMatrixForH[HWG];
            case "hwk": return positionsMatrixForH[HWK];
            case "hwm": return positionsMatrixForH[HWM];
            case "hwt": return positionsMatrixForH[HWT];
            case "hwx": return positionsMatrixForH[HWX];
            case "hyb": return positionsMatrixForH[HYB];
            case "hyd": return positionsMatrixForH[HYD];
            case "hyl": return positionsMatrixForH[HYL];
            case "hym": return positionsMatrixForH[HYM];
            case "hyp": return positionsMatrixForH[HYP];
            case "hyr": return positionsMatrixForH[HYR];
            case "hys": return positionsMatrixForH[HYS];
            case "hyt": return positionsMatrixForH[HYT];
            case "hyv": return positionsMatrixForH[HYV];
            case "hyz": return positionsMatrixForH[HYZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForJ(String tripleConsonant) {
        switch(tripleConsonant) {
            case "jwc": return positionsMatrixForJ[JWC];
            case "jwg": return positionsMatrixForJ[JWG];
            case "jwk": return positionsMatrixForJ[JWK];
            case "jwm": return positionsMatrixForJ[JWM];
            case "jwt": return positionsMatrixForJ[JWT];
            case "jwx": return positionsMatrixForJ[JWX];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForK(String tripleConsonant) {
        switch(tripleConsonant) {
            case "kkl": return positionsMatrixForK[KKL];
            case "kkr": return positionsMatrixForK[KKR];
            case "kks": return positionsMatrixForK[KKS];
            case "kky": return positionsMatrixForK[KKY];
            case "klw": return positionsMatrixForK[KLW];
            case "kly": return positionsMatrixForK[KLY];
            case "knn": return positionsMatrixForK[KNN];
            case "kns": return positionsMatrixForK[KNS];
            case "knt": return positionsMatrixForK[KNT];
            case "kny": return positionsMatrixForK[KNY];
            case "knz": return positionsMatrixForK[KNZ];
            case "krn": return positionsMatrixForK[KRN];
            case "krs": return positionsMatrixForK[KRS];
            case "kry": return positionsMatrixForK[KRY];
            case "krz": return positionsMatrixForK[KRZ];
            case "ksg": return positionsMatrixForK[KSG];
            case "ksh": return positionsMatrixForK[KSH];
            case "ksm": return positionsMatrixForK[KSM];
            case "ksp": return positionsMatrixForK[KSP];
            case "kss": return positionsMatrixForK[KSS];
            case "kst": return positionsMatrixForK[KST];
            case "ksw": return positionsMatrixForK[KSW];
            case "ksy": return positionsMatrixForK[KSY];
            case "kyb": return positionsMatrixForK[KYB];
            case "kyl": return positionsMatrixForK[KYL];
            case "kym": return positionsMatrixForK[KYM];
            case "kyp": return positionsMatrixForK[KYP];
            case "kyr": return positionsMatrixForK[KYR];
            case "kys": return positionsMatrixForK[KYS];
            case "kyt": return positionsMatrixForK[KYT];
            case "kyv": return positionsMatrixForK[KYV];
            case "kyz": return positionsMatrixForK[KYZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForL(String tripleConsonant) {
        switch(tripleConsonant) {
            case "lbb": return positionsMatrixForL[LBB];
            case "lbh": return positionsMatrixForL[LBH];
            case "lbl": return positionsMatrixForL[LBL];
            case "lbr": return positionsMatrixForL[LBR];
            case "lby": return positionsMatrixForL[LBY];
            case "lbz": return positionsMatrixForL[LBZ];
            case "lch": return positionsMatrixForL[LCH];
            case "lcl": return positionsMatrixForL[LCL];
            case "lcr": return positionsMatrixForL[LCR];
            case "ldd": return positionsMatrixForL[LDD];
            case "ldh": return positionsMatrixForL[LDH];
            case "ldr": return positionsMatrixForL[LDR];
            case "lds": return positionsMatrixForL[LDS];
            case "ldw": return positionsMatrixForL[LDW];
            case "ldy": return positionsMatrixForL[LDY];
            case "lff": return positionsMatrixForL[LFF];
            case "lfl": return positionsMatrixForL[LFL];
            case "lfr": return positionsMatrixForL[LFR];
            case "lfs": return positionsMatrixForL[LFS];
            case "lfz": return positionsMatrixForL[LFZ];
            case "lgg": return positionsMatrixForL[LGG];
            case "lgh": return positionsMatrixForL[LGH];
            case "lgl": return positionsMatrixForL[LGL];
            case "lgr": return positionsMatrixForL[LGR];
            case "lkh": return positionsMatrixForL[LKH];
            case "lkk": return positionsMatrixForL[LKK];
            case "lkl": return positionsMatrixForL[LKL];
            case "lkr": return positionsMatrixForL[LKR];
            case "lky": return positionsMatrixForL[LKY];
            case "llw": return positionsMatrixForL[LLW];
            case "lly": return positionsMatrixForL[LLY];
            case "lmy": return positionsMatrixForL[LMY];
            case "lsc": return positionsMatrixForL[LSC];
            case "lsh": return positionsMatrixForL[LSH];
            case "lsn": return positionsMatrixForL[LSN];
            case "lss": return positionsMatrixForL[LSS];
            case "lsw": return positionsMatrixForL[LSW];
            case "lsy": return positionsMatrixForL[LSY];
            case "lth": return positionsMatrixForL[LTH];
            case "ltr": return positionsMatrixForL[LTR];
            case "ltt": return positionsMatrixForL[LTT];
            case "ltw": return positionsMatrixForL[LTW];
            case "lty": return positionsMatrixForL[LTY];
            case "ltz": return positionsMatrixForL[LTZ];
            case "lwc": return positionsMatrixForL[LWC];
            case "lwg": return positionsMatrixForL[LWG];
            case "lwk": return positionsMatrixForL[LWK];
            case "lwm": return positionsMatrixForL[LWM];
            case "lwt": return positionsMatrixForL[LWT];
            case "lwx": return positionsMatrixForL[LWX];
            case "lyb": return positionsMatrixForL[LYB];
            case "lyl": return positionsMatrixForL[LYL];
            case "lym": return positionsMatrixForL[LYM];
            case "lyp": return positionsMatrixForL[LYP];
            case "lyr": return positionsMatrixForL[LYR];
            case "lys": return positionsMatrixForL[LYS];
            case "lyt": return positionsMatrixForL[LYT];
            case "lyv": return positionsMatrixForL[LYV];
            case "lyz": return positionsMatrixForL[LYZ];
            case "lzy": return positionsMatrixForL[LZY];
            case "lzz": return positionsMatrixForL[LZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForM(String tripleConsonant) {
        switch(tripleConsonant) {
            case "mbb": return positionsMatrixForM[MBB];
            case "mbh": return positionsMatrixForM[MBH];
            case "mbl": return positionsMatrixForM[MBL];
            case "mbr": return positionsMatrixForM[MBR];
            case "mby": return positionsMatrixForM[MBY];
            case "myb": return positionsMatrixForM[MYB];
            case "myl": return positionsMatrixForM[MYL];
            case "mym": return positionsMatrixForM[MYM];
            case "myp": return positionsMatrixForM[MYP];
            case "myr": return positionsMatrixForM[MYR];
            case "mys": return positionsMatrixForM[MYS];
            case "myt": return positionsMatrixForM[MYT];
            case "myv": return positionsMatrixForM[MYV];
            case "myz": return positionsMatrixForM[MYZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForN(String tripleConsonant) {
        switch(tripleConsonant) {
            case "nbb": return positionsMatrixForN[NBB];
            case "nbh": return positionsMatrixForN[NBH];
            case "nbl": return positionsMatrixForN[NBL];
            case "nbr": return positionsMatrixForN[NBR];
            case "nby": return positionsMatrixForN[NBY];
            case "nbz": return positionsMatrixForN[NBZ];
            case "nch": return positionsMatrixForN[NCH];
            case "ncl": return positionsMatrixForN[NCL];
            case "ncr": return positionsMatrixForN[NCR];
            case "ndd": return positionsMatrixForN[NDD];
            case "ndh": return positionsMatrixForN[NDH];
            case "ndr": return positionsMatrixForN[NDR];
            case "nds": return positionsMatrixForN[NDS];
            case "ndw": return positionsMatrixForN[NDW];
            case "ndy": return positionsMatrixForN[NDY];
            case "nff": return positionsMatrixForN[NFF];
            case "nfl": return positionsMatrixForN[NFL];
            case "nfr": return positionsMatrixForN[NFR];
            case "nfs": return positionsMatrixForN[NFS];
            case "nfz": return positionsMatrixForN[NFZ];
            case "ngg": return positionsMatrixForN[NGG];
            case "ngh": return positionsMatrixForN[NGH];
            case "ngl": return positionsMatrixForN[NGL];
            case "ngr": return positionsMatrixForN[NGR];
            case "nkh": return positionsMatrixForN[NKH];
            case "nkk": return positionsMatrixForN[NKK];
            case "nkl": return positionsMatrixForN[NKL];
            case "nkr": return positionsMatrixForN[NKR];
            case "nks": return positionsMatrixForN[NKS];
            case "nky": return positionsMatrixForN[NKY];
            case "nnb": return positionsMatrixForN[NNB];
            case "nnc": return positionsMatrixForN[NNC];
            case "nnd": return positionsMatrixForN[NND];
            case "nnf": return positionsMatrixForN[NNF];
            case "nng": return positionsMatrixForN[NNG];
            case "nnk": return positionsMatrixForN[NNK];
            case "nnp": return positionsMatrixForN[NNP];
            case "nnq": return positionsMatrixForN[NNQ];
            case "nns": return positionsMatrixForN[NNS];
            case "nnt": return positionsMatrixForN[NNT];
            case "nny": return positionsMatrixForN[NNY];
            case "nnz": return positionsMatrixForN[NNZ];
            case "nph": return positionsMatrixForN[NPH];
            case "npl": return positionsMatrixForN[NPL];
            case "npp": return positionsMatrixForN[NPP];
            case "npr": return positionsMatrixForN[NPR];
            case "nps": return positionsMatrixForN[NPS];
            case "npy": return positionsMatrixForN[NPY];
            case "nsh": return positionsMatrixForN[NSH];
            case "nss": return positionsMatrixForN[NSS];
            case "nsw": return positionsMatrixForN[NSW];
            case "nsy": return positionsMatrixForN[NSY];
            case "nth": return positionsMatrixForN[NTH];
            case "ntr": return positionsMatrixForN[NTR];
            case "ntt": return positionsMatrixForN[NTT];
            case "ntw": return positionsMatrixForN[NTW];
            case "nty": return positionsMatrixForN[NTY];
            case "ntz": return positionsMatrixForN[NTZ];
            case "nxx": return positionsMatrixForN[NXX];
            case "nyb": return positionsMatrixForN[NYB];
            case "nyl": return positionsMatrixForN[NYL];
            case "nym": return positionsMatrixForN[NYM];
            case "nyp": return positionsMatrixForN[NYP];
            case "nyr": return positionsMatrixForN[NYR];
            case "nys": return positionsMatrixForN[NYS];
            case "nyt": return positionsMatrixForN[NYT];
            case "nyv": return positionsMatrixForN[NYV];
            case "nyz": return positionsMatrixForN[NYZ];
            case "nzy": return positionsMatrixForN[NZY];
            case "nzz": return positionsMatrixForN[NZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForP(String tripleConsonant) {
        switch(tripleConsonant) {
            case "plw": return positionsMatrixForP[PLW];
            case "ply": return positionsMatrixForP[PLY];
            case "pny": return positionsMatrixForP[PNY];
            case "ppl": return positionsMatrixForP[PPL];
            case "ppn": return positionsMatrixForP[PPN];
            case "ppr": return positionsMatrixForP[PPR];
            case "pps": return positionsMatrixForP[PPS];
            case "ppt": return positionsMatrixForP[PPT];
            case "ppy": return positionsMatrixForP[PPY];
            case "prs": return positionsMatrixForP[PRS];
            case "pry": return positionsMatrixForP[PRY];
            case "psh": return positionsMatrixForP[PSH];
            case "psk": return positionsMatrixForP[PSK];
            case "psn": return positionsMatrixForP[PSN];
            case "pss": return positionsMatrixForP[PSS];
            case "pst": return positionsMatrixForP[PST];
            case "psy": return positionsMatrixForP[PSY];
            case "pth": return positionsMatrixForP[PTH];
            case "ptr": return positionsMatrixForP[PTR];
            case "pty": return positionsMatrixForP[PTY];
            case "pxx": return positionsMatrixForP[PXX];
            case "pyb": return positionsMatrixForP[PYB];
            case "pyl": return positionsMatrixForP[PYL];
            case "pym": return positionsMatrixForP[PYM];
            case "pyp": return positionsMatrixForP[PYP];
            case "pyr": return positionsMatrixForP[PYR];
            case "pys": return positionsMatrixForP[PYS];
            case "pyt": return positionsMatrixForP[PYT];
            case "pyv": return positionsMatrixForP[PYV];
            case "pyz": return positionsMatrixForP[PYZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForR(String tripleConsonant) {
        switch(tripleConsonant) {
            case "rbb": return positionsMatrixForR[RBB];
            case "rbh": return positionsMatrixForR[RBH];
            case "rbl": return positionsMatrixForR[RBL];
            case "rbr": return positionsMatrixForR[RBR];
            case "rby": return positionsMatrixForR[RBY];
            case "rch": return positionsMatrixForR[RCH];
            case "rcl": return positionsMatrixForR[RCL];
            case "rdd": return positionsMatrixForR[RDD];
            case "rdh": return positionsMatrixForR[RDH];
            case "rds": return positionsMatrixForR[RDS];
            case "rdw": return positionsMatrixForR[RDW];
            case "rdy": return positionsMatrixForR[RDY];
            case "rff": return positionsMatrixForR[RFF];
            case "rfl": return positionsMatrixForR[RFL];
            case "rfr": return positionsMatrixForR[RFR];
            case "rfs": return positionsMatrixForR[RFS];
            case "rfz": return positionsMatrixForR[RFZ];
            case "rgg": return positionsMatrixForR[RGG];
            case "rgh": return positionsMatrixForR[RGH];
            case "rgl": return positionsMatrixForR[RGL];
            case "rjw": return positionsMatrixForR[RJW];
            case "rkh": return positionsMatrixForR[RKH];
            case "rkk": return positionsMatrixForR[RKK];
            case "rkl": return positionsMatrixForR[RKL];
            case "rkn": return positionsMatrixForR[RKN];
            case "rks": return positionsMatrixForR[RKS];
            case "rky": return positionsMatrixForR[RKY];
            case "rlw": return positionsMatrixForR[RLW];
            case "rly": return positionsMatrixForR[RLY];
            case "rmy": return positionsMatrixForR[RMY];
            case "rnx": return positionsMatrixForR[RNX];
            case "rny": return positionsMatrixForR[RNY];
            case "rnz": return positionsMatrixForR[RNZ];
            case "rph": return positionsMatrixForR[RPH];
            case "rpl": return positionsMatrixForR[RPL];
            case "rpn": return positionsMatrixForR[RPN];
            case "rpp": return positionsMatrixForR[RPP];
            case "rps": return positionsMatrixForR[RPS];
            case "rpy": return positionsMatrixForR[RPY];
            case "rry": return positionsMatrixForR[RRY];
            case "rsh": return positionsMatrixForR[RSH];
            case "rss": return positionsMatrixForR[RSS];
            case "rsw": return positionsMatrixForR[RSW];
            case "rsy": return positionsMatrixForR[RSY];
            case "rth": return positionsMatrixForR[RTH];
            case "rts": return positionsMatrixForR[RTS];
            case "rtt": return positionsMatrixForR[RTT];
            case "rtw": return positionsMatrixForR[RTW];
            case "rty": return positionsMatrixForR[RTY];
            case "rtz": return positionsMatrixForR[RTZ];
            case "rvl": return positionsMatrixForR[RVL];
            case "rvn": return positionsMatrixForR[RVN];
            case "rvs": return positionsMatrixForR[RVS];
            case "rvv": return positionsMatrixForR[RVV];
            case "rvy": return positionsMatrixForR[RVY];
            case "rvz": return positionsMatrixForR[RVZ];
            case "ryb": return positionsMatrixForR[RYB];
            case "ryl": return positionsMatrixForR[RYL];
            case "rym": return positionsMatrixForR[RYM];
            case "ryp": return positionsMatrixForR[RYP];
            case "ryr": return positionsMatrixForR[RYR];
            case "rys": return positionsMatrixForR[RYS];
            case "ryt": return positionsMatrixForR[RYT];
            case "ryv": return positionsMatrixForR[RYV];
            case "ryz": return positionsMatrixForR[RYZ];
            case "rzg": return positionsMatrixForR[RZG];
            case "rzy": return positionsMatrixForR[RZY];
            case "rzz": return positionsMatrixForR[RZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForS(String tripleConsonant) {
        switch(tripleConsonant) {
            case "sbb": return positionsMatrixForS[SBB];
            case "sbh": return positionsMatrixForS[SBH];
            case "sbr": return positionsMatrixForS[SBR];
            case "sby": return positionsMatrixForS[SBY];
            case "sch": return positionsMatrixForS[SCH];
            case "scl": return positionsMatrixForS[SCL];
            case "scr": return positionsMatrixForS[SCR];
            case "sgg": return positionsMatrixForS[SGG];
            case "sgh": return positionsMatrixForS[SGH];
            case "sgl": return positionsMatrixForS[SGL];
            case "sgr": return positionsMatrixForS[SGR];
            case "skh": return positionsMatrixForS[SKH];
            case "skk": return positionsMatrixForS[SKK];
            case "skl": return positionsMatrixForS[SKL];
            case "skr": return positionsMatrixForS[SKR];
            case "sky": return positionsMatrixForS[SKY];
            case "smy": return positionsMatrixForS[SMY];
            case "snn": return positionsMatrixForS[SNN];
            case "sny": return positionsMatrixForS[SNY];
            case "sph": return positionsMatrixForS[SPH];
            case "spl": return positionsMatrixForS[SPL];
            case "spp": return positionsMatrixForS[SPP];
            case "spr": return positionsMatrixForS[SPR];
            case "spy": return positionsMatrixForS[SPY];
            case "ssb": return positionsMatrixForS[SSB];
            case "ssg": return positionsMatrixForS[SSG];
            case "ssk": return positionsMatrixForS[SSK];
            case "ssn": return positionsMatrixForS[SSN];
            case "ssp": return positionsMatrixForS[SSP];
            case "sst": return positionsMatrixForS[SST];
            case "ssw": return positionsMatrixForS[SSW];
            case "sth": return positionsMatrixForS[STH];
            case "stl": return positionsMatrixForS[STL];
            case "str": return positionsMatrixForS[STR];
            case "stt": return positionsMatrixForS[STT];
            case "stw": return positionsMatrixForS[STW];
            case "sty": return positionsMatrixForS[STY];
            case "svl": return positionsMatrixForS[SVL];
            case "svr": return positionsMatrixForS[SVR];
            case "svv": return positionsMatrixForS[SVV];
            case "svy": return positionsMatrixForS[SVY];
            case "swb": return positionsMatrixForS[SWB];
            case "swg": return positionsMatrixForS[SWG];
            case "swk": return positionsMatrixForS[SWK];
            case "swm": return positionsMatrixForS[SWM];
            case "swt": return positionsMatrixForS[SWT];
            case "swx": return positionsMatrixForS[SWX];
            case "syb": return positionsMatrixForS[SYB];
            case "syl": return positionsMatrixForS[SYL];
            case "sym": return positionsMatrixForS[SYM];
            case "syp": return positionsMatrixForS[SYP];
            case "syr": return positionsMatrixForS[SYR];
            case "sys": return positionsMatrixForS[SYS];
            case "syt": return positionsMatrixForS[SYT];
            case "syv": return positionsMatrixForS[SYV];
            case "syz": return positionsMatrixForS[SYZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForT(String tripleConsonant) {
        switch(tripleConsonant) {
            case "trs": return positionsMatrixForT[TRS];
            case "try": return positionsMatrixForT[TRY];
            case "trz": return positionsMatrixForT[TRZ];
            case "tsb": return positionsMatrixForT[TSB];
            case "tsg": return positionsMatrixForT[TSG];
            case "tsh": return positionsMatrixForT[TSH];
            case "tsn": return positionsMatrixForT[TSN];
            case "tss": return positionsMatrixForT[TSS];
            case "tsv": return positionsMatrixForT[TSV];
            case "tsw": return positionsMatrixForT[TSW];
            case "tsy": return positionsMatrixForT[TSY];
            case "ttw": return positionsMatrixForT[TTW];
            case "tty": return positionsMatrixForT[TTY];
            case "twc": return positionsMatrixForT[TWC];
            case "twg": return positionsMatrixForT[TWG];
            case "twk": return positionsMatrixForT[TWK];
            case "twm": return positionsMatrixForT[TWM];
            case "twt": return positionsMatrixForT[TWT];
            case "twx": return positionsMatrixForT[TWX];
            case "tyb": return positionsMatrixForT[TYB];
            case "tyl": return positionsMatrixForT[TYL];
            case "tym": return positionsMatrixForT[TYM];
            case "typ": return positionsMatrixForT[TYP];
            case "tyr": return positionsMatrixForT[TYR];
            case "tys": return positionsMatrixForT[TYS];
            case "tyt": return positionsMatrixForT[TYT];
            case "tyv": return positionsMatrixForT[TYV];
            case "tyz": return positionsMatrixForT[TYZ];
            case "tzc": return positionsMatrixForT[TZC];
            case "tzd": return positionsMatrixForT[TZD];
            case "tzf": return positionsMatrixForT[TZF];
            case "tzg": return positionsMatrixForT[TZG];
            case "tzk": return positionsMatrixForT[TZK];
            case "tzn": return positionsMatrixForT[TZN];
            case "tzy": return positionsMatrixForT[TZY];
            case "tzz": return positionsMatrixForT[TZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForV(String tripleConsonant) {
        switch(tripleConsonant) {
            case "vls": return positionsMatrixForV[VLS];
            case "vly": return positionsMatrixForV[VLY];
            case "vnn": return positionsMatrixForV[VNN];
            case "vns": return positionsMatrixForV[VNS];
            case "vnx": return positionsMatrixForV[VNX];
            case "vny": return positionsMatrixForV[VNY];
            case "vrs": return positionsMatrixForV[VRS];
            case "vry": return positionsMatrixForV[VRY];
            case "vrz": return positionsMatrixForV[VRZ];
            case "vsc": return positionsMatrixForV[VSC];
            case "vsh": return positionsMatrixForV[VSH];
            case "vsk": return positionsMatrixForV[VSK];
            case "vsl": return positionsMatrixForV[VSL];
            case "vsn": return positionsMatrixForV[VSN];
            case "vss": return positionsMatrixForV[VSS];
            case "vst": return positionsMatrixForV[VST];
            case "vsw": return positionsMatrixForV[VSW];
            case "vsy": return positionsMatrixForV[VSY];
            case "vvy": return positionsMatrixForV[VVY];
            case "vyb": return positionsMatrixForV[VYB];
            case "vyl": return positionsMatrixForV[VYL];
            case "vym": return positionsMatrixForV[VYM];
            case "vyp": return positionsMatrixForV[VYP];
            case "vyr": return positionsMatrixForV[VYR];
            case "vys": return positionsMatrixForV[VYS];
            case "vyt": return positionsMatrixForV[VYT];
            case "vyv": return positionsMatrixForV[VYV];
            case "vyz": return positionsMatrixForV[VYZ];
            case "vzc": return positionsMatrixForV[VZC];
            case "vzg": return positionsMatrixForV[VZG];
            case "vzy": return positionsMatrixForV[VZY];
            case "vzz": return positionsMatrixForV[VZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForW(String tripleConsonant) {
        switch(tripleConsonant) {
            case "wcc": return positionsMatrixForW[WCC];
            case "wch": return positionsMatrixForW[WCH];
            case "wcl": return positionsMatrixForW[WCL];
            case "wcr": return positionsMatrixForW[WCR];
            case "wgg": return positionsMatrixForW[WGG];
            case "wgh": return positionsMatrixForW[WGH];
            case "wgl": return positionsMatrixForW[WGL];
            case "wgm": return positionsMatrixForW[WGM];
            case "wgr": return positionsMatrixForW[WGR];
            case "wkh": return positionsMatrixForW[WKH];
            case "wkk": return positionsMatrixForW[WKK];
            case "wkl": return positionsMatrixForW[WKL];
            case "wkn": return positionsMatrixForW[WKN];
            case "wkr": return positionsMatrixForW[WKR];
            case "wks": return positionsMatrixForW[WKS];
            case "wky": return positionsMatrixForW[WKY];
            case "wmb": return positionsMatrixForW[WMB];
            case "wmy": return positionsMatrixForW[WMY];
            case "wth": return positionsMatrixForW[WTH];
            case "wtl": return positionsMatrixForW[WTL];
            case "wtr": return positionsMatrixForW[WTR];
            case "wts": return positionsMatrixForW[WTS];
            case "wtt": return positionsMatrixForW[WTT];
            case "wtw": return positionsMatrixForW[WTW];
            case "wty": return positionsMatrixForW[WTY];
            case "wtz": return positionsMatrixForW[WTZ];
            case "wxt": return positionsMatrixForW[WXT];
            case "wxx": return positionsMatrixForW[WXX];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForX(String tripleConsonant) {
        switch(tripleConsonant) {
            case "xth": return positionsMatrixForX[XTH];
            case "xtr": return positionsMatrixForX[XTR];
            case "xtt": return positionsMatrixForX[XTT];
            case "xtw": return positionsMatrixForX[XTW];
            case "xty": return positionsMatrixForX[XTY];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForY(String tripleConsonant) {
        switch(tripleConsonant) {
            case "ybb": return positionsMatrixForY[YBB];
            case "ybh": return positionsMatrixForY[YBH];
            case "ybl": return positionsMatrixForY[YBL];
            case "ybr": return positionsMatrixForY[YBR];
            case "ybs": return positionsMatrixForY[YBS];
            case "yby": return positionsMatrixForY[YBY];
            case "ybz": return positionsMatrixForY[YBZ];
            case "ydd": return positionsMatrixForY[YDD];
            case "ydg": return positionsMatrixForY[YDG];
            case "ydh": return positionsMatrixForY[YDH];
            case "ydk": return positionsMatrixForY[YDK];
            case "ydm": return positionsMatrixForY[YDM];
            case "ydr": return positionsMatrixForY[YDR];
            case "yds": return positionsMatrixForY[YDS];
            case "ydw": return positionsMatrixForY[YDW];
            case "ydy": return positionsMatrixForY[YDY];
            case "ylb": return positionsMatrixForY[YLB];
            case "ylc": return positionsMatrixForY[YLC];
            case "yld": return positionsMatrixForY[YLD];
            case "ylf": return positionsMatrixForY[YLF];
            case "ylg": return positionsMatrixForY[YLG];
            case "ylk": return positionsMatrixForY[YLK];
            case "yll": return positionsMatrixForY[YLL];
            case "ylm": return positionsMatrixForY[YLM];
            case "yls": return positionsMatrixForY[YLS];
            case "ylt": return positionsMatrixForY[YLT];
            case "ylw": return positionsMatrixForY[YLW];
            case "yly": return positionsMatrixForY[YLY];
            case "ylz": return positionsMatrixForY[YLZ];
            case "ymb": return positionsMatrixForY[YMB];
            case "ymy": return positionsMatrixForY[YMY];
            case "yph": return positionsMatrixForY[YPH];
            case "ypl": return positionsMatrixForY[YPL];
            case "ypb": return positionsMatrixForY[YPB];
            case "ypp": return positionsMatrixForY[YPP];
            case "ypr": return positionsMatrixForY[YPR];
            case "yps": return positionsMatrixForY[YPS];
            case "ypt": return positionsMatrixForY[YPT];
            case "ypx": return positionsMatrixForY[YPX];
            case "ypy": return positionsMatrixForY[YPY];
            case "yrb": return positionsMatrixForY[YRB];
            case "yrc": return positionsMatrixForY[YRC];
            case "yrd": return positionsMatrixForY[YRD];
            case "yrf": return positionsMatrixForY[YRF];
            case "yrg": return positionsMatrixForY[YRG];
            case "yrj": return positionsMatrixForY[YRJ];
            case "yrk": return positionsMatrixForY[YRK];
            case "yrl": return positionsMatrixForY[YRL];
            case "yrm": return positionsMatrixForY[YRM];
            case "yrn": return positionsMatrixForY[YRN];
            case "yrp": return positionsMatrixForY[YRP];
            case "yrq": return positionsMatrixForY[YRQ];
            case "yrr": return positionsMatrixForY[YRR];
            case "yrs": return positionsMatrixForY[YRS];
            case "yrt": return positionsMatrixForY[YRT];
            case "yrv": return positionsMatrixForY[YRV];
            case "yry": return positionsMatrixForY[YRY];
            case "yrz": return positionsMatrixForY[YRZ];
            case "ysb": return positionsMatrixForY[YSB];
            case "ysc": return positionsMatrixForY[YSC];
            case "ysg": return positionsMatrixForY[YSG];
            case "ysh": return positionsMatrixForY[YSH];
            case "ysk": return positionsMatrixForY[YSK];
            case "ysl": return positionsMatrixForY[YSL];
            case "ysm": return positionsMatrixForY[YSM];
            case "ysn": return positionsMatrixForY[YSN];
            case "ysp": return positionsMatrixForY[YSP];
            case "ysq": return positionsMatrixForY[YSQ];
            case "yss": return positionsMatrixForY[YSS];
            case "yst": return positionsMatrixForY[YST];
            case "ysv": return positionsMatrixForY[YSV];
            case "ysw": return positionsMatrixForY[YSW];
            case "ysy": return positionsMatrixForY[YSY];
            case "yth": return positionsMatrixForY[YTH];
            case "ytl": return positionsMatrixForY[YTL];
            case "ytr": return positionsMatrixForY[YTR];
            case "yts": return positionsMatrixForY[YTS];
            case "ytt": return positionsMatrixForY[YTT];
            case "ytw": return positionsMatrixForY[YTW];
            case "yty": return positionsMatrixForY[YTY];
            case "ytz": return positionsMatrixForY[YTZ];
            case "yvl": return positionsMatrixForY[YVL];
            case "yvn": return positionsMatrixForY[YVN];
            case "yvr": return positionsMatrixForY[YVR];
            case "yvs": return positionsMatrixForY[YVS];
            case "yvv": return positionsMatrixForY[YVV];
            case "yvy": return positionsMatrixForY[YVY];
            case "yvz": return positionsMatrixForY[YVZ];
            case "yzb": return positionsMatrixForY[YZB];
            case "yzc": return positionsMatrixForY[YZC];
            case "yzd": return positionsMatrixForY[YZD];
            case "yzf": return positionsMatrixForY[YZF];
            case "yzg": return positionsMatrixForY[YZG];
            case "yzk": return positionsMatrixForY[YZK];
            case "yzn": return positionsMatrixForY[YZN];
            case "yzy": return positionsMatrixForY[YZY];
            case "yzz": return positionsMatrixForY[YZZ];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    private boolean[] getValidPositionsForZ(String tripleConsonant) {
        switch(tripleConsonant) {
            case "zbb": return positionsMatrixForZ[ZBB];
            case "zbh": return positionsMatrixForZ[ZBH];
            case "zbr": return positionsMatrixForZ[ZBR];
            case "zby": return positionsMatrixForZ[ZBY];
            case "zch": return positionsMatrixForZ[ZCH];
            case "zcl": return positionsMatrixForZ[ZCL];
            case "zdd": return positionsMatrixForZ[ZDD];
            case "zdh": return positionsMatrixForZ[ZDH];
            case "zdr": return positionsMatrixForZ[ZDR];
            case "zdw": return positionsMatrixForZ[ZDW];
            case "zdy": return positionsMatrixForZ[ZDY];
            case "zff": return positionsMatrixForZ[ZFF];
            case "zfl": return positionsMatrixForZ[ZFL];
            case "zfr": return positionsMatrixForZ[ZFR];
            case "zgg": return positionsMatrixForZ[ZGG];
            case "zgh": return positionsMatrixForZ[ZGH];
            case "zgl": return positionsMatrixForZ[ZGL];
            case "zgr": return positionsMatrixForZ[ZGR];
            case "zkh": return positionsMatrixForZ[ZKH];
            case "zkk": return positionsMatrixForZ[ZKK];
            case "zkl": return positionsMatrixForZ[ZKL];
            case "zkr": return positionsMatrixForZ[ZKR];
            case "zky": return positionsMatrixForZ[ZKY];
            case "znn": return positionsMatrixForZ[ZNN];
            case "zny": return positionsMatrixForZ[ZNY];
            case "zyb": return positionsMatrixForZ[ZYB];
            case "zyl": return positionsMatrixForZ[ZYL];
            case "zym": return positionsMatrixForZ[ZYM];
            case "zyp": return positionsMatrixForZ[ZYP];
            case "zyr": return positionsMatrixForZ[ZYR];
            case "zys": return positionsMatrixForZ[ZYS];
            case "zyt": return positionsMatrixForZ[ZYT];
            case "zyv": return positionsMatrixForZ[ZYV];
            case "zyz": return positionsMatrixForZ[ZYZ];
            case "zzy": return positionsMatrixForZ[ZZY];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    /**
     * Obtains the first character into a string.
     *
     * @param   tripleCharacter string to obtain its first character.
     * @return                  fisrts character.
     * */
    private char getFirstCharacter(String tripleCharacter) {
        return tripleCharacter.charAt(0);
    }

    /**
     * Obtains the proper sub-collection for first character of triple
     * consonant token.
     *
     * @param   firstCharacter triple consonant token first character
     * @return                 collection of triple consonant tokens
     * */
    private String getTripleConsonants(char firstCharacter) {
        switch(firstCharacter) {
            case 'b': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_B;
            case 'c': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_C;
            case 'd': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_D;
            case 'f': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_F;
            case 'g': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_G;
            case 'h': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_H;
            case 'J': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_J;
            case 'k': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_K;
            case 'l': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_L;
            case 'm': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_M;
            case 'n': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_N;
            case 'p': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_P;
            case 'r': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_R;
            case 's': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_S;
            case 't': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_T;
            case 'v': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_V;
            case 'w': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_W;
            case 'x': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_X;
            case 'y': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_Y;
            case 'z': return TRIPLE_CONSONANTS_THAT_STARTS_WITH_Z;
        }
        return NO_CONSONANTS;
    }

    /**
     * Initializes the matrix that contains all positions about
     * triple consonant tokens.
     * */
    private void initPositionsMatrix() {
        this.positionsMatrixForB
            = new boolean[getCollectionSizeForB()][NUMBER_OF_POSITIONS];
        positionsMatrixForB[BBR] = new boolean[] {false,true,false};
        positionsMatrixForB[BBS] = new boolean[] {false,true,false};
        positionsMatrixForB[BBY] = new boolean[] {false,true,true};
        positionsMatrixForB[BLW] = new boolean[] {true,true,true};
        positionsMatrixForB[BLY] = new boolean[] {true,true,true};
        positionsMatrixForB[BRY] = new boolean[] {true,true,true};
        positionsMatrixForB[BSY] = new boolean[] {true,true,true};
        positionsMatrixForB[BYB] = new boolean[] {true,true,true};
        positionsMatrixForB[BYL] = new boolean[] {true,true,true};
        positionsMatrixForB[BYM] = new boolean[] {true,true,true};
        positionsMatrixForB[BYP] = new boolean[] {true,true,true};
        positionsMatrixForB[BYR] = new boolean[] {true,true,true};
        positionsMatrixForB[BYS] = new boolean[] {true,true,true};
        positionsMatrixForB[BYT] = new boolean[] {true,true,true};
        positionsMatrixForB[BYV] = new boolean[] {true,true,true};
        positionsMatrixForB[BYZ] = new boolean[] {true,true,true};
        positionsMatrixForB[BZY] = new boolean[] {true,true,true};

        this.positionsMatrixForC
            = new boolean[getCollectionSizeForC()][NUMBER_OF_POSITIONS];
        positionsMatrixForC[CCL] = new boolean[] {false,true,false};
        positionsMatrixForC[CCR] = new boolean[] {false,true,false};
        positionsMatrixForC[CRY] = new boolean[] {true,true,true};

        this.positionsMatrixForD
            = new boolean[getCollectionSizeForD()][NUMBER_OF_POSITIONS];
        positionsMatrixForD[DDR] = new boolean[] {false,true,false};
        positionsMatrixForD[DDS] = new boolean[] {false,true,false};
        positionsMatrixForD[DDY] = new boolean[] {false,true,true};
        positionsMatrixForD[DGG] = new boolean[] {false,true,false};
        positionsMatrixForD[DGH] = new boolean[] {false,true,false};
        positionsMatrixForD[DGL] = new boolean[] {false,true,false};
        positionsMatrixForD[DGR] = new boolean[] {false,true,false};
        positionsMatrixForD[DKH] = new boolean[] {false,true,false};
        positionsMatrixForD[DKK] = new boolean[] {false,true,false};
        positionsMatrixForD[DKL] = new boolean[] {false,true,false};
        positionsMatrixForD[DKR] = new boolean[] {false,true,false};
        positionsMatrixForD[DKY] = new boolean[] {false,true,true};
        positionsMatrixForD[DMY] = new boolean[] {false,true,true};
        positionsMatrixForD[DRY] = new boolean[] {true,true,true};
        positionsMatrixForD[DSH] = new boolean[] {false,true,false};
        positionsMatrixForD[DWC] = new boolean[] {true,true,true};
        positionsMatrixForD[DWG] = new boolean[] {true,true,true};
        positionsMatrixForD[DWK] = new boolean[] {true,true,true};
        positionsMatrixForD[DWM] = new boolean[] {true,true,true};
        positionsMatrixForD[DWT] = new boolean[] {true,true,true};
        positionsMatrixForD[DWX] = new boolean[] {true,true,true};
        positionsMatrixForD[DYB] = new boolean[] {true,true,false};
        positionsMatrixForD[DYL] = new boolean[] {true,true,true};
        positionsMatrixForD[DYM] = new boolean[] {true,true,true};
        positionsMatrixForD[DYP] = new boolean[] {true,true,false};
        positionsMatrixForD[DYR] = new boolean[] {true,true,false};
        positionsMatrixForD[DYS] = new boolean[] {true,true,true};
        positionsMatrixForD[DYT] = new boolean[] {true,true,true};
        positionsMatrixForD[DYV] = new boolean[] {true,true,true};
        positionsMatrixForD[DYZ] = new boolean[] {true,true,true};

        this.positionsMatrixForF
            = new boolean[getCollectionSizeForF()][NUMBER_OF_POSITIONS];
        positionsMatrixForF[FFL] = new boolean[] {false,true,false};
        positionsMatrixForF[FFR] = new boolean[] {false,true,true};
        positionsMatrixForF[FFS] = new boolean[] {false,true,true};
        positionsMatrixForF[FFZ] = new boolean[] {false,true,false};
        positionsMatrixForF[FLW] = new boolean[] {true,true,true};
        positionsMatrixForF[FLY] = new boolean[] {true,true,true};
        positionsMatrixForF[FLZ] = new boolean[] {false,false,true};
        positionsMatrixForF[FNN] = new boolean[] {false,true,false};
        positionsMatrixForF[FNS] = new boolean[] {false,false,true};
        positionsMatrixForF[FNX] = new boolean[] {false,false,true};
        positionsMatrixForF[FNY] = new boolean[] {false,true,true};
        positionsMatrixForF[FNZ] = new boolean[] {false,false,true};
        positionsMatrixForF[FRS] = new boolean[] {false,false,true};
        positionsMatrixForF[FRY] = new boolean[] {true,true,true};
        positionsMatrixForF[FRZ] = new boolean[] {false,false,true};
        positionsMatrixForF[FSC] = new boolean[] {false,true,false};
        positionsMatrixForF[FSG] = new boolean[] {false,true,false};
        positionsMatrixForF[FSH] = new boolean[] {false,true,false};
        positionsMatrixForF[FSK] = new boolean[] {false,true,false};
        positionsMatrixForF[FSS] = new boolean[] {false,true,false};
        positionsMatrixForF[FST] = new boolean[] {false,true,false};
        positionsMatrixForF[FSW] = new boolean[] {false,true,true};
        positionsMatrixForF[FSY] = new boolean[] {false,true,true};
        positionsMatrixForF[FZK] = new boolean[] {false,true,false};
        positionsMatrixForF[FZN] = new boolean[] {false,true,false};
        positionsMatrixForF[FZY] = new boolean[] {false,true,true};
        positionsMatrixForF[FZZ] = new boolean[] {false,true,false};

        this.positionsMatrixForG
            = new boolean[getCollectionSizeForG()][NUMBER_OF_POSITIONS];
        positionsMatrixForG[GGL] = new boolean[] {false,true,false};
        positionsMatrixForG[GGR] = new boolean[] {false,true,false};
        positionsMatrixForG[GLS] = new boolean[] {false,false,true};
        positionsMatrixForG[GLW] = new boolean[] {true,true,true};
        positionsMatrixForG[GLY] = new boolean[] {true,true,true};
        positionsMatrixForG[GMY] = new boolean[] {false,true,true};
        positionsMatrixForG[GRR] = new boolean[] {false,true,false};
        positionsMatrixForG[GRS] = new boolean[] {false,false,true};
        positionsMatrixForG[GRY] = new boolean[] {true,true,true};

        this.positionsMatrixForH
            = new boolean[getCollectionSizeForH()][NUMBER_OF_POSITIONS];
        positionsMatrixForH[HWC] = new boolean[] {true,true,true};
        positionsMatrixForH[HWG] = new boolean[] {true,true,true};
        positionsMatrixForH[HWK] = new boolean[] {true,true,true};
        positionsMatrixForH[HWM] = new boolean[] {true,true,true};
        positionsMatrixForH[HWT] = new boolean[] {true,true,true};
        positionsMatrixForH[HWX] = new boolean[] {true,true,true};
        positionsMatrixForH[HYB] = new boolean[] {true,true,true};
        positionsMatrixForH[HYD] = new boolean[] {true,true,true};
        positionsMatrixForH[HYL] = new boolean[] {true,true,true};
        positionsMatrixForH[HYM] = new boolean[] {true,true,true};
        positionsMatrixForH[HYP] = new boolean[] {true,true,true};
        positionsMatrixForH[HYR] = new boolean[] {true,true,true};
        positionsMatrixForH[HYS] = new boolean[] {true,true,true};
        positionsMatrixForH[HYT] = new boolean[] {true,true,true};
        positionsMatrixForH[HYV] = new boolean[] {true,true,true};
        positionsMatrixForH[HYZ] = new boolean[] {true,true,true};

        this.positionsMatrixForJ
            = new boolean[getCollectionSizeForJ()][NUMBER_OF_POSITIONS];
        positionsMatrixForJ[JWC] = new boolean[] {true,true,true};
        positionsMatrixForJ[JWG] = new boolean[] {true,true,true};
        positionsMatrixForJ[JWK] = new boolean[] {true,true,true};
        positionsMatrixForJ[JWM] = new boolean[] {true,true,true};
        positionsMatrixForJ[JWT] = new boolean[] {true,true,true};
        positionsMatrixForJ[JWX] = new boolean[] {true,true,true};

        this.positionsMatrixForK
            = new boolean[getCollectionSizeForK()][NUMBER_OF_POSITIONS];
        positionsMatrixForK[KKL] = new boolean[] {false,true,false};
        positionsMatrixForK[KKR] = new boolean[] {false,true,false};
        positionsMatrixForK[KKS] = new boolean[] {false,true,false};
        positionsMatrixForK[KKY] = new boolean[] {false,true,true};
        positionsMatrixForK[KLW] = new boolean[] {true,true,true};
        positionsMatrixForK[KLY] = new boolean[] {true,true,true};
        positionsMatrixForK[KNN] = new boolean[] {false,true,false};
        positionsMatrixForK[KNS] = new boolean[] {false,false,true};
        positionsMatrixForK[KNT] = new boolean[] {false,false,true};
        positionsMatrixForK[KNY] = new boolean[] {true,true,true};
        positionsMatrixForK[KNZ] = new boolean[] {false,false,true};
        positionsMatrixForK[KRN] = new boolean[] {false,false,true};
        positionsMatrixForK[KRS] = new boolean[] {false,false,true};
        positionsMatrixForK[KRY] = new boolean[] {true,true,true};
        positionsMatrixForK[KRZ] = new boolean[] {false,false,true};
        positionsMatrixForK[KSG] = new boolean[] {false,true,false};
        positionsMatrixForK[KSH] = new boolean[] {false,true,false};
        positionsMatrixForK[KSM] = new boolean[] {false,true,false};
        positionsMatrixForK[KSP] = new boolean[] {false,true,false};
        positionsMatrixForK[KSS] = new boolean[] {false,true,false};
        positionsMatrixForK[KST] = new boolean[] {false,true,false};
        positionsMatrixForK[KSW] = new boolean[] {true,true,true};
        positionsMatrixForK[KSY] = new boolean[] {true,true,true};
        positionsMatrixForK[KYB] = new boolean[] {true,true,true};
        positionsMatrixForK[KYL] = new boolean[] {true,true,true};
        positionsMatrixForK[KYM] = new boolean[] {true,true,true};
        positionsMatrixForK[KYP] = new boolean[] {true,true,true};
        positionsMatrixForK[KYR] = new boolean[] {true,true,true};
        positionsMatrixForK[KYS] = new boolean[] {true,true,true};
        positionsMatrixForK[KYT] = new boolean[] {true,true,true};
        positionsMatrixForK[KYV] = new boolean[] {true,true,true};
        positionsMatrixForK[KYZ] = new boolean[] {true,true,true};

        this.positionsMatrixForL
            = new boolean[getCollectionSizeForL()][NUMBER_OF_POSITIONS];
        positionsMatrixForL[LBB] = new boolean[] {false,true,false};
        positionsMatrixForL[LBH] = new boolean[] {false,true,false};
        positionsMatrixForL[LBL] = new boolean[] {false,true,false};
        positionsMatrixForL[LBR] = new boolean[] {false,true,true};
        positionsMatrixForL[LBY] = new boolean[] {false,true,true};
        positionsMatrixForL[LBZ] = new boolean[] {false,true,true};
        positionsMatrixForL[LCH] = new boolean[] {false,true,false};
        positionsMatrixForL[LCL] = new boolean[] {false,true,false};
        positionsMatrixForL[LCR] = new boolean[] {false,true,true};
        positionsMatrixForL[LDD] = new boolean[] {false,true,false};
        positionsMatrixForL[LDH] = new boolean[] {false,true,false};
        positionsMatrixForL[LDR] = new boolean[] {false,true,true};
        positionsMatrixForL[LDS] = new boolean[] {false,true,true};
        positionsMatrixForL[LDW] = new boolean[] {false,true,true};
        positionsMatrixForL[LDY] = new boolean[] {false,true,true};
        positionsMatrixForL[LFF] = new boolean[] {false,true,false};
        positionsMatrixForL[LFL] = new boolean[] {false,true,false};
        positionsMatrixForL[LFR] = new boolean[] {false,true,true};
        positionsMatrixForL[LFS] = new boolean[] {false,true,true};
        positionsMatrixForL[LFZ] = new boolean[] {false,true,true};
        positionsMatrixForL[LGG] = new boolean[] {false,true,false};
        positionsMatrixForL[LGH] = new boolean[] {false,true,false};
        positionsMatrixForL[LGL] = new boolean[] {false,true,false};
        positionsMatrixForL[LGR] = new boolean[] {false,true,true};
        positionsMatrixForL[LKH] = new boolean[] {false,true,false};
        positionsMatrixForL[LKK] = new boolean[] {false,true,false};
        positionsMatrixForL[LKL] = new boolean[] {false,true,false};
        positionsMatrixForL[LKR] = new boolean[] {false,true,true};
        positionsMatrixForL[LKY] = new boolean[] {false,true,true};
        positionsMatrixForL[LLW] = new boolean[] {true,true,true};
        positionsMatrixForL[LLY] = new boolean[] {true,true,true};
        positionsMatrixForL[LMY] = new boolean[] {false,true,true};
        positionsMatrixForL[LSC] = new boolean[] {false,true,false};
        positionsMatrixForL[LSH] = new boolean[] {false,true,false};
        positionsMatrixForL[LSN] = new boolean[] {false,true,false};
        positionsMatrixForL[LSS] = new boolean[] {false,true,false};
        positionsMatrixForL[LSW] = new boolean[] {false,true,true};
        positionsMatrixForL[LSY] = new boolean[] {false,true,true};
        positionsMatrixForL[LTH] = new boolean[] {false,true,false};
        positionsMatrixForL[LTR] = new boolean[] {false,true,true};
        positionsMatrixForL[LTT] = new boolean[] {false,true,false};
        positionsMatrixForL[LTW] = new boolean[] {false,true,true};
        positionsMatrixForL[LTY] = new boolean[] {false,true,true};
        positionsMatrixForL[LTZ] = new boolean[] {false,true,false};
        positionsMatrixForL[LWC] = new boolean[] {true,true,true};
        positionsMatrixForL[LWG] = new boolean[] {true,true,true};
        positionsMatrixForL[LWK] = new boolean[] {true,true,true};
        positionsMatrixForL[LWM] = new boolean[] {true,true,true};
        positionsMatrixForL[LWT] = new boolean[] {true,true,true};
        positionsMatrixForL[LWX] = new boolean[] {true,true,true};
        positionsMatrixForL[LYB] = new boolean[] {true,true,true};
        positionsMatrixForL[LYL] = new boolean[] {true,true,true};
        positionsMatrixForL[LYM] = new boolean[] {true,true,true};
        positionsMatrixForL[LYP] = new boolean[] {true,true,true};
        positionsMatrixForL[LYR] = new boolean[] {true,true,true};
        positionsMatrixForL[LYS] = new boolean[] {true,true,true};
        positionsMatrixForL[LYT] = new boolean[] {true,true,true};
        positionsMatrixForL[LYV] = new boolean[] {true,true,true};
        positionsMatrixForL[LYZ] = new boolean[] {true,true,true};
        positionsMatrixForL[LZY] = new boolean[] {false,true,true};
        positionsMatrixForL[LZZ] = new boolean[] {false,true,false};

        this.positionsMatrixForM
            = new boolean[getCollectionSizeForM()][NUMBER_OF_POSITIONS];
        positionsMatrixForM[MBB] = new boolean[] {false,true,false};
        positionsMatrixForM[MBH] = new boolean[] {false,true,false};
        positionsMatrixForM[MBL] = new boolean[] {false,true,true};
        positionsMatrixForM[MBR] = new boolean[] {false,true,true};
        positionsMatrixForM[MBY] = new boolean[] {false,true,true};
        positionsMatrixForM[MYB] = new boolean[] {true,true,true};
        positionsMatrixForM[MYL] = new boolean[] {true,true,true};
        positionsMatrixForM[MYM] = new boolean[] {true,true,true};
        positionsMatrixForM[MYP] = new boolean[] {true,true,true};
        positionsMatrixForM[MYR] = new boolean[] {true,true,true};
        positionsMatrixForM[MYS] = new boolean[] {true,true,true};
        positionsMatrixForM[MYT] = new boolean[] {true,true,true};
        positionsMatrixForM[MYV] = new boolean[] {true,true,true};
        positionsMatrixForM[MYZ] = new boolean[] {true,true,true};

        this.positionsMatrixForN
            = new boolean[getCollectionSizeForN()][NUMBER_OF_POSITIONS];
        positionsMatrixForN[NBB] = new boolean[] {false,true,false};
        positionsMatrixForN[NBH] = new boolean[] {false,true,false};
        positionsMatrixForN[NBL] = new boolean[] {false,true,true};
        positionsMatrixForN[NBR] = new boolean[] {false,true,true};
        positionsMatrixForN[NBY] = new boolean[] {false,true,true};
        positionsMatrixForN[NBZ] = new boolean[] {false,true,false};
        positionsMatrixForN[NCH] = new boolean[] {false,true,true};
        positionsMatrixForN[NCL] = new boolean[] {false,true,false};
        positionsMatrixForN[NCR] = new boolean[] {false,true,false};
        positionsMatrixForN[NDD] = new boolean[] {false,true,false};
        positionsMatrixForN[NDH] = new boolean[] {false,true,false};
        positionsMatrixForN[NDR] = new boolean[] {false,true,false};
        positionsMatrixForN[NDS] = new boolean[] {false,true,true};
        positionsMatrixForN[NDW] = new boolean[] {false,true,true};
        positionsMatrixForN[NDY] = new boolean[] {false,true,true};
        positionsMatrixForN[NFF] = new boolean[] {false,true,false};
        positionsMatrixForN[NFL] = new boolean[] {false,true,true};
        positionsMatrixForN[NFR] = new boolean[] {false,true,true};
        positionsMatrixForN[NFS] = new boolean[] {false,true,false};
        positionsMatrixForN[NFZ] = new boolean[] {false,true,false};
        positionsMatrixForN[NGG] = new boolean[] {false,true,false};
        positionsMatrixForN[NGH] = new boolean[] {false,true,false};
        positionsMatrixForN[NGL] = new boolean[] {false,true,false};
        positionsMatrixForN[NGR] = new boolean[] {false,true,false};
        positionsMatrixForN[NKH] = new boolean[] {false,true,false};
        positionsMatrixForN[NKK] = new boolean[] {false,true,false};
        positionsMatrixForN[NKL] = new boolean[] {false,true,false};
        positionsMatrixForN[NKR] = new boolean[] {false,true,false};
        positionsMatrixForN[NKS] = new boolean[] {false,true,false};
        positionsMatrixForN[NKY] = new boolean[] {false,true,true};
        positionsMatrixForN[NNB] = new boolean[] {false,true,false};
        positionsMatrixForN[NNC] = new boolean[] {false,true,false};
        positionsMatrixForN[NND] = new boolean[] {false,true,false};
        positionsMatrixForN[NNF] = new boolean[] {false,true,false};
        positionsMatrixForN[NNG] = new boolean[] {false,true,false};
        positionsMatrixForN[NNK] = new boolean[] {false,true,false};
        positionsMatrixForN[NNP] = new boolean[] {false,true,false};
        positionsMatrixForN[NNQ] = new boolean[] {false,true,false};
        positionsMatrixForN[NNS] = new boolean[] {false,true,true};
        positionsMatrixForN[NNT] = new boolean[] {false,true,true};
        positionsMatrixForN[NNY] = new boolean[] {false,true,true};
        positionsMatrixForN[NNZ] = new boolean[] {false,true,true};
        positionsMatrixForN[NPH] = new boolean[] {false,true,false};
        positionsMatrixForN[NPL] = new boolean[] {false,true,false};
        positionsMatrixForN[NPP] = new boolean[] {false,true,false};
        positionsMatrixForN[NPR] = new boolean[] {false,true,true};
        positionsMatrixForN[NPS] = new boolean[] {false,true,false};
        positionsMatrixForN[NPY] = new boolean[] {false,true,true};
        positionsMatrixForN[NSH] = new boolean[] {false,true,false};
        positionsMatrixForN[NSS] = new boolean[] {false,true,false};
        positionsMatrixForN[NSW] = new boolean[] {false,true,true};
        positionsMatrixForN[NSY] = new boolean[] {false,true,true};
        positionsMatrixForN[NTH] = new boolean[] {false,true,false};
        positionsMatrixForN[NTR] = new boolean[] {false,true,false};
        positionsMatrixForN[NTT] = new boolean[] {false,true,false};
        positionsMatrixForN[NTW] = new boolean[] {false,true,true};
        positionsMatrixForN[NTY] = new boolean[] {false,true,true};
        positionsMatrixForN[NTZ] = new boolean[] {false,true,true};
        positionsMatrixForN[NXX] = new boolean[] {false,true,false};
        positionsMatrixForN[NYB] = new boolean[] {true,true,true};
        positionsMatrixForN[NYL] = new boolean[] {true,true,true};
        positionsMatrixForN[NYM] = new boolean[] {true,true,true};
        positionsMatrixForN[NYP] = new boolean[] {true,true,true};
        positionsMatrixForN[NYR] = new boolean[] {true,true,true};
        positionsMatrixForN[NYS] = new boolean[] {true,true,true};
        positionsMatrixForN[NYT] = new boolean[] {true,true,true};
        positionsMatrixForN[NYV] = new boolean[] {true,true,true};
        positionsMatrixForN[NYZ] = new boolean[] {true,true,true};
        positionsMatrixForN[NZY] = new boolean[] {false,true,true};
        positionsMatrixForN[NZZ] = new boolean[] {false,true,false};

        this.positionsMatrixForP
            = new boolean[getCollectionSizeForP()][NUMBER_OF_POSITIONS];
        positionsMatrixForP[PLW] = new boolean[] {true,true,true};
        positionsMatrixForP[PLY] = new boolean[] {true,true,true};
        positionsMatrixForP[PNY] = new boolean[] {false,true,true};
        positionsMatrixForP[PPL] = new boolean[] {false,true,false};
        positionsMatrixForP[PPN] = new boolean[] {false,true,false};
        positionsMatrixForP[PPR] = new boolean[] {false,true,false};
        positionsMatrixForP[PPS] = new boolean[] {false,true,true};
        positionsMatrixForP[PPT] = new boolean[] {false,true,false};
        positionsMatrixForP[PPY] = new boolean[] {false,true,true};
        positionsMatrixForP[PRS] = new boolean[] {false,false,true};
        positionsMatrixForP[PRY] = new boolean[] {false,true,true};
        positionsMatrixForP[PSH] = new boolean[] {false,true,false};
        positionsMatrixForP[PSK] = new boolean[] {false,true,false};
        positionsMatrixForP[PSN] = new boolean[] {false,true,false};
        positionsMatrixForP[PSS] = new boolean[] {false,true,false};
        positionsMatrixForP[PST] = new boolean[] {false,true,false};
        positionsMatrixForP[PSY] = new boolean[] {true,true,true};
        positionsMatrixForP[PTH] = new boolean[] {false,true,false};
        positionsMatrixForP[PTR] = new boolean[] {false,true,false};
        positionsMatrixForP[PTY] = new boolean[] {false,true,true};
        positionsMatrixForP[PXX] = new boolean[] {false,true,false};
        positionsMatrixForP[PYB] = new boolean[] {true,true,true};
        positionsMatrixForP[PYL] = new boolean[] {true,true,true};
        positionsMatrixForP[PYM] = new boolean[] {true,true,true};
        positionsMatrixForP[PYP] = new boolean[] {true,true,true};
        positionsMatrixForP[PYR] = new boolean[] {true,true,true};
        positionsMatrixForP[PYS] = new boolean[] {true,true,true};
        positionsMatrixForP[PYT] = new boolean[] {true,true,true};
        positionsMatrixForP[PYV] = new boolean[] {true,true,true};
        positionsMatrixForP[PYZ] = new boolean[] {true,true,true};

        this.positionsMatrixForR
            = new boolean[getCollectionSizeForR()][NUMBER_OF_POSITIONS];
        positionsMatrixForR[RBB] = new boolean[] {false,true,false};
        positionsMatrixForR[RBH] = new boolean[] {false,true,false};
        positionsMatrixForR[RBL] = new boolean[] {false,true,false};
        positionsMatrixForR[RBR] = new boolean[] {false,true,false};
        positionsMatrixForR[RBY] = new boolean[] {false,true,true};
        positionsMatrixForR[RCH] = new boolean[] {false,true,true};
        positionsMatrixForR[RCL] = new boolean[] {false,true,false};
        positionsMatrixForR[RDD] = new boolean[] {false,true,false};
        positionsMatrixForR[RDH] = new boolean[] {false,true,false};
        positionsMatrixForR[RDS] = new boolean[] {false,true,true};
        positionsMatrixForR[RDW] = new boolean[] {false,true,true};
        positionsMatrixForR[RDY] = new boolean[] {false,true,true};
        positionsMatrixForR[RFF] = new boolean[] {false,true,false};
        positionsMatrixForR[RFL] = new boolean[] {false,true,false};
        positionsMatrixForR[RFR] = new boolean[] {false,true,false};
        positionsMatrixForR[RFS] = new boolean[] {false,true,true};
        positionsMatrixForR[RFZ] = new boolean[] {false,true,true};
        positionsMatrixForR[RGG] = new boolean[] {false,true,false};
        positionsMatrixForR[RGH] = new boolean[] {false,true,false};
        positionsMatrixForR[RGL] = new boolean[] {false,true,false};
        positionsMatrixForR[RJW] = new boolean[] {false,true,true};
        positionsMatrixForR[RKH] = new boolean[] {false,true,false};
        positionsMatrixForR[RKK] = new boolean[] {false,true,false};
        positionsMatrixForR[RKL] = new boolean[] {false,true,true};
        positionsMatrixForR[RKN] = new boolean[] {false,true,false};
        positionsMatrixForR[RKS] = new boolean[] {false,true,true};
        positionsMatrixForR[RKY] = new boolean[] {false,true,true};
        positionsMatrixForR[RLW] = new boolean[] {false,true,true};
        positionsMatrixForR[RLY] = new boolean[] {false,true,true};
        positionsMatrixForR[RMY] = new boolean[] {false,true,true};
        positionsMatrixForR[RNX] = new boolean[] {false,false,true};
        positionsMatrixForR[RNY] = new boolean[] {false,true,true};
        positionsMatrixForR[RNZ] = new boolean[] {false,false,true};
        positionsMatrixForR[RPH] = new boolean[] {false,true,false};
        positionsMatrixForR[RPL] = new boolean[] {false,true,false};
        positionsMatrixForR[RPN] = new boolean[] {false,true,false};
        positionsMatrixForR[RPP] = new boolean[] {false,true,false};
        positionsMatrixForR[RPS] = new boolean[] {false,true,true};
        positionsMatrixForR[RPY] = new boolean[] {false,true,true};
        positionsMatrixForR[RRY] = new boolean[] {false,true,true};
        positionsMatrixForR[RSH] = new boolean[] {false,true,false};
        positionsMatrixForR[RSS] = new boolean[] {false,true,false};
        positionsMatrixForR[RSW] = new boolean[] {false,true,true};
        positionsMatrixForR[RSY] = new boolean[] {false,true,true};
        positionsMatrixForR[RTH] = new boolean[] {false,true,false};
        positionsMatrixForR[RTS] = new boolean[] {false,true,true};
        positionsMatrixForR[RTT] = new boolean[] {false,true,false};
        positionsMatrixForR[RTW] = new boolean[] {false,true,true};
        positionsMatrixForR[RTY] = new boolean[] {false,true,true};
        positionsMatrixForR[RTZ] = new boolean[] {false,true,true};
        positionsMatrixForR[RVL] = new boolean[] {false,true,false};
        positionsMatrixForR[RVN] = new boolean[] {false,true,false};
        positionsMatrixForR[RVS] = new boolean[] {false,true,true};
        positionsMatrixForR[RVV] = new boolean[] {false,true,false};
        positionsMatrixForR[RVY] = new boolean[] {false,true,true};
        positionsMatrixForR[RVZ] = new boolean[] {false,true,true};
        positionsMatrixForR[RYB] = new boolean[] {true,true,true};
        positionsMatrixForR[RYL] = new boolean[] {true,true,true};
        positionsMatrixForR[RYM] = new boolean[] {true,true,true};
        positionsMatrixForR[RYP] = new boolean[] {true,true,true};
        positionsMatrixForR[RYR] = new boolean[] {true,true,true};
        positionsMatrixForR[RYS] = new boolean[] {true,true,true};
        positionsMatrixForR[RYT] = new boolean[] {true,true,true};
        positionsMatrixForR[RYV] = new boolean[] {true,true,true};
        positionsMatrixForR[RYZ] = new boolean[] {true,true,true};
        positionsMatrixForR[RZG] = new boolean[] {false,true,false};
        positionsMatrixForR[RZY] = new boolean[] {false,true,true};
        positionsMatrixForR[RZZ] = new boolean[] {false,true,false};

        this.positionsMatrixForS
            = new boolean[getCollectionSizeForS()][NUMBER_OF_POSITIONS];
        positionsMatrixForS[SBB] = new boolean[] {false,true,false};
        positionsMatrixForS[SBH] = new boolean[] {false,true,false};
        positionsMatrixForS[SBR] = new boolean[] {false,true,false};
        positionsMatrixForS[SBY] = new boolean[] {false,true,true};
        positionsMatrixForS[SCH] = new boolean[] {false,true,false};
        positionsMatrixForS[SCL] = new boolean[] {false,true,false};
        positionsMatrixForS[SCR] = new boolean[] {false,true,false};
        positionsMatrixForS[SGG] = new boolean[] {false,true,false};
        positionsMatrixForS[SGH] = new boolean[] {false,true,false};
        positionsMatrixForS[SGL] = new boolean[] {false,true,false};
        positionsMatrixForS[SGR] = new boolean[] {false,true,false};
        positionsMatrixForS[SKH] = new boolean[] {false,true,false};
        positionsMatrixForS[SKK] = new boolean[] {false,true,false};
        positionsMatrixForS[SKL] = new boolean[] {false,true,false};
        positionsMatrixForS[SKR] = new boolean[] {false,true,false};
        positionsMatrixForS[SKY] = new boolean[] {false,true,true};
        positionsMatrixForS[SMY] = new boolean[] {true,true,true};
        positionsMatrixForS[SNN] = new boolean[] {false,true,false};
        positionsMatrixForS[SNY] = new boolean[] {true,true,true};
        positionsMatrixForS[SPH] = new boolean[] {true,true,true};
        positionsMatrixForS[SPL] = new boolean[] {true,true,false};
        positionsMatrixForS[SPP] = new boolean[] {true,true,false};
        positionsMatrixForS[SPR] = new boolean[] {true,true,false};
        positionsMatrixForS[SPY] = new boolean[] {true,true,true};
        positionsMatrixForS[SSB] = new boolean[] {false,true,false};
        positionsMatrixForS[SSG] = new boolean[] {false,true,false};
        positionsMatrixForS[SSK] = new boolean[] {false,true,false};
        positionsMatrixForS[SSN] = new boolean[] {false,true,false};
        positionsMatrixForS[SSP] = new boolean[] {false,true,false};
        positionsMatrixForS[SST] = new boolean[] {false,true,false};
        positionsMatrixForS[SSW] = new boolean[] {false,true,true};
        positionsMatrixForS[STH] = new boolean[] {false,true,false};
        positionsMatrixForS[STL] = new boolean[] {false,true,false};
        positionsMatrixForS[STR] = new boolean[] {false,true,true};
        positionsMatrixForS[STT] = new boolean[] {false,true,false};
        positionsMatrixForS[STW] = new boolean[] {true,true,true};
        positionsMatrixForS[STY] = new boolean[] {true,true,true};
        positionsMatrixForS[SVL] = new boolean[] {false,true,false};
        positionsMatrixForS[SVR] = new boolean[] {false,true,false};
        positionsMatrixForS[SVV] = new boolean[] {false,true,false};
        positionsMatrixForS[SVY] = new boolean[] {true,true,true};
        positionsMatrixForS[SWB] = new boolean[] {true,true,true};
        positionsMatrixForS[SWG] = new boolean[] {true,true,true};
        positionsMatrixForS[SWK] = new boolean[] {true,true,true};
        positionsMatrixForS[SWM] = new boolean[] {true,true,true};
        positionsMatrixForS[SWT] = new boolean[] {true,true,true};
        positionsMatrixForS[SWX] = new boolean[] {true,true,true};
        positionsMatrixForS[SYB] = new boolean[] {true,true,true};
        positionsMatrixForS[SYL] = new boolean[] {true,true,true};
        positionsMatrixForS[SYM] = new boolean[] {true,true,true};
        positionsMatrixForS[SYP] = new boolean[] {true,true,true};
        positionsMatrixForS[SYR] = new boolean[] {true,true,true};
        positionsMatrixForS[SYS] = new boolean[] {true,true,true};
        positionsMatrixForS[SYT] = new boolean[] {true,true,true};
        positionsMatrixForS[SYV] = new boolean[] {true,true,true};
        positionsMatrixForS[SYZ] = new boolean[] {true,true,true};

        this.positionsMatrixForT
            = new boolean[getCollectionSizeForT()][NUMBER_OF_POSITIONS];
        positionsMatrixForT[TRS] = new boolean[] {false,false,true};
        positionsMatrixForT[TRY] = new boolean[] {true,true,true};
        positionsMatrixForT[TRZ] = new boolean[] {false,false,true};
        positionsMatrixForT[TSB] = new boolean[] {false,true,false};
        positionsMatrixForT[TSG] = new boolean[] {false,true,false};
        positionsMatrixForT[TSH] = new boolean[] {false,true,false};
        positionsMatrixForT[TSN] = new boolean[] {false,true,false};
        positionsMatrixForT[TSS] = new boolean[] {false,true,false};
        positionsMatrixForT[TSV] = new boolean[] {false,true,false};
        positionsMatrixForT[TSW] = new boolean[] {true,true,true};
        positionsMatrixForT[TSY] = new boolean[] {true,true,true};
        positionsMatrixForT[TTW] = new boolean[] {false,true,true};
        positionsMatrixForT[TTY] = new boolean[] {false,true,true};
        positionsMatrixForT[TWC] = new boolean[] {true,true,true};
        positionsMatrixForT[TWG] = new boolean[] {true,true,true};
        positionsMatrixForT[TWK] = new boolean[] {true,true,true};
        positionsMatrixForT[TWM] = new boolean[] {true,true,true};
        positionsMatrixForT[TWT] = new boolean[] {true,true,true};
        positionsMatrixForT[TWX] = new boolean[] {true,true,true};
        positionsMatrixForT[TYB] = new boolean[] {true,true,true};
        positionsMatrixForT[TYL] = new boolean[] {true,true,true};
        positionsMatrixForT[TYM] = new boolean[] {true,true,true};
        positionsMatrixForT[TYP] = new boolean[] {true,true,true};
        positionsMatrixForT[TYR] = new boolean[] {true,true,true};
        positionsMatrixForT[TYS] = new boolean[] {true,true,true};
        positionsMatrixForT[TYT] = new boolean[] {true,true,true};
        positionsMatrixForT[TYV] = new boolean[] {true,true,true};
        positionsMatrixForT[TYZ] = new boolean[] {true,true,true};
        positionsMatrixForT[TZC] = new boolean[] {false,true,false};
        positionsMatrixForT[TZD] = new boolean[] {false,true,false};
        positionsMatrixForT[TZF] = new boolean[] {false,true,false};
        positionsMatrixForT[TZG] = new boolean[] {false,true,false};
        positionsMatrixForT[TZK] = new boolean[] {false,true,false};
        positionsMatrixForT[TZN] = new boolean[] {false,true,false};
        positionsMatrixForT[TZY] = new boolean[] {true,true,true};
        positionsMatrixForT[TZZ] = new boolean[] {false,true,false};

        this.positionsMatrixForV
            = new boolean[getCollectionSizeForV()][NUMBER_OF_POSITIONS];
        positionsMatrixForV[VLS] = new boolean[] {false,false,true};
        positionsMatrixForV[VLY] = new boolean[] {true,true,true};
        positionsMatrixForV[VNN] = new boolean[] {false,true,false};
        positionsMatrixForV[VNS] = new boolean[] {false,false,true};
        positionsMatrixForV[VNX] = new boolean[] {false,false,true};
        positionsMatrixForV[VNY] = new boolean[] {false,true,true};
        positionsMatrixForV[VRS] = new boolean[] {false,false,true};
        positionsMatrixForV[VRY] = new boolean[] {true,true,true};
        positionsMatrixForV[VRZ] = new boolean[] {false,false,true};
        positionsMatrixForV[VSC] = new boolean[] {false,true,false};
        positionsMatrixForV[VSH] = new boolean[] {false,true,false};
        positionsMatrixForV[VSK] = new boolean[] {false,true,false};
        positionsMatrixForV[VSL] = new boolean[] {false,true,true};
        positionsMatrixForV[VSN] = new boolean[] {false,true,true};
        positionsMatrixForV[VSS] = new boolean[] {false,true,false};
        positionsMatrixForV[VST] = new boolean[] {false,true,false};
        positionsMatrixForV[VSW] = new boolean[] {true,true,true};
        positionsMatrixForV[VSY] = new boolean[] {true,true,true};
        positionsMatrixForV[VVY] = new boolean[] {false,true,true};
        positionsMatrixForV[VYB] = new boolean[] {true,true,true};
        positionsMatrixForV[VYL] = new boolean[] {true,true,true};
        positionsMatrixForV[VYM] = new boolean[] {true,true,true};
        positionsMatrixForV[VYP] = new boolean[] {true,true,true};
        positionsMatrixForV[VYR] = new boolean[] {true,true,true};
        positionsMatrixForV[VYS] = new boolean[] {true,true,true};
        positionsMatrixForV[VYT] = new boolean[] {true,true,true};
        positionsMatrixForV[VYV] = new boolean[] {true,true,true};
        positionsMatrixForV[VYZ] = new boolean[] {true,true,true};
        positionsMatrixForV[VZC] = new boolean[] {false,true,false};
        positionsMatrixForV[VZG] = new boolean[] {false,true,false};
        positionsMatrixForV[VZY] = new boolean[] {true,true,true};
        positionsMatrixForV[VZZ] = new boolean[] {false,true,false};

        this.positionsMatrixForW
            = new boolean[getCollectionSizeForW()][NUMBER_OF_POSITIONS];
        positionsMatrixForW[WCC] = new boolean[] {true,true,false};
        positionsMatrixForW[WCH] = new boolean[] {true,true,false};
        positionsMatrixForW[WCL] = new boolean[] {true,true,false};
        positionsMatrixForW[WCR] = new boolean[] {true,true,false};
        positionsMatrixForW[WGG] = new boolean[] {true,true,false};
        positionsMatrixForW[WGH] = new boolean[] {true,true,false};
        positionsMatrixForW[WGL] = new boolean[] {true,true,false};
        positionsMatrixForW[WGM] = new boolean[] {true,true,false};
        positionsMatrixForW[WGR] = new boolean[] {true,true,false};
        positionsMatrixForW[WKH] = new boolean[] {true,true,false};
        positionsMatrixForW[WKK] = new boolean[] {true,true,false};
        positionsMatrixForW[WKL] = new boolean[] {true,true,false};
        positionsMatrixForW[WKN] = new boolean[] {true,true,false};
        positionsMatrixForW[WKR] = new boolean[] {true,true,false};
        positionsMatrixForW[WKS] = new boolean[] {true,true,false};
        positionsMatrixForW[WKY] = new boolean[] {true,true,false};
        positionsMatrixForW[WMB] = new boolean[] {true,true,false};
        positionsMatrixForW[WMY] = new boolean[] {true,true,false};
        positionsMatrixForW[WTH] = new boolean[] {true,true,false};
        positionsMatrixForW[WTL] = new boolean[] {true,true,false};
        positionsMatrixForW[WTR] = new boolean[] {true,true,false};
        positionsMatrixForW[WTS] = new boolean[] {true,true,false};
        positionsMatrixForW[WTT] = new boolean[] {true,true,false};
        positionsMatrixForW[WTW] = new boolean[] {true,true,false};
        positionsMatrixForW[WTY] = new boolean[] {true,true,false};
        positionsMatrixForW[WTZ] = new boolean[] {true,true,false};
        positionsMatrixForW[WXT] = new boolean[] {true,true,false};
        positionsMatrixForW[WXX] = new boolean[] {true,true,false};

        this.positionsMatrixForX
            = new boolean[getCollectionSizeForX()][NUMBER_OF_POSITIONS];
        positionsMatrixForX[XTH] = new boolean[] {false,true,false};
        positionsMatrixForX[XTR] = new boolean[] {true,true,false};
        positionsMatrixForX[XTT] = new boolean[] {false,true,false};
        positionsMatrixForX[XTW] = new boolean[] {false,true,true};
        positionsMatrixForX[XTY] = new boolean[] {false,true,true};

        this.positionsMatrixForY
            = new boolean[getCollectionSizeForY()][NUMBER_OF_POSITIONS];
        positionsMatrixForY[YBB] = new boolean[] {true,true,false};
        positionsMatrixForY[YBH] = new boolean[] {true,true,false};
        positionsMatrixForY[YBL] = new boolean[] {true,true,false};
        positionsMatrixForY[YBR] = new boolean[] {true,true,false};
        positionsMatrixForY[YBS] = new boolean[] {true,true,false};
        positionsMatrixForY[YBY] = new boolean[] {true,true,false};
        positionsMatrixForY[YBZ] = new boolean[] {true,true,false};
        positionsMatrixForY[YDD] = new boolean[] {true,true,false};
        positionsMatrixForY[YDG] = new boolean[] {true,true,false};
        positionsMatrixForY[YDH] = new boolean[] {true,true,false};
        positionsMatrixForY[YDK] = new boolean[] {true,true,false};
        positionsMatrixForY[YDM] = new boolean[] {true,true,false};
        positionsMatrixForY[YDR] = new boolean[] {true,true,false};
        positionsMatrixForY[YDS] = new boolean[] {true,true,false};
        positionsMatrixForY[YDW] = new boolean[] {true,true,false};
        positionsMatrixForY[YDY] = new boolean[] {true,true,false};
        positionsMatrixForY[YLB] = new boolean[] {true,true,false};
        positionsMatrixForY[YLC] = new boolean[] {true,true,false};
        positionsMatrixForY[YLD] = new boolean[] {true,true,false};
        positionsMatrixForY[YLF] = new boolean[] {true,true,false};
        positionsMatrixForY[YLG] = new boolean[] {true,true,false};
        positionsMatrixForY[YLK] = new boolean[] {true,true,false};
        positionsMatrixForY[YLL] = new boolean[] {true,true,false};
        positionsMatrixForY[YLM] = new boolean[] {true,true,false};
        positionsMatrixForY[YLS] = new boolean[] {true,true,false};
        positionsMatrixForY[YLT] = new boolean[] {true,true,false};
        positionsMatrixForY[YLW] = new boolean[] {true,true,false};
        positionsMatrixForY[YLY] = new boolean[] {true,true,false};
        positionsMatrixForY[YLZ] = new boolean[] {true,true,false};
        positionsMatrixForY[YMB] = new boolean[] {true,true,false};
        positionsMatrixForY[YMY] = new boolean[] {true,true,false};
        positionsMatrixForY[YPH] = new boolean[] {true,true,false};
        positionsMatrixForY[YPL] = new boolean[] {true,true,false};
        positionsMatrixForY[YPB] = new boolean[] {true,true,false};
        positionsMatrixForY[YPP] = new boolean[] {true,true,false};
        positionsMatrixForY[YPR] = new boolean[] {true,true,false};
        positionsMatrixForY[YPS] = new boolean[] {true,true,false};
        positionsMatrixForY[YPT] = new boolean[] {true,true,false};
        positionsMatrixForY[YPX] = new boolean[] {true,true,false};
        positionsMatrixForY[YPY] = new boolean[] {true,true,false};
        positionsMatrixForY[YRB] = new boolean[] {true,true,false};
        positionsMatrixForY[YRC] = new boolean[] {true,true,false};
        positionsMatrixForY[YRD] = new boolean[] {true,true,false};
        positionsMatrixForY[YRF] = new boolean[] {true,true,false};
        positionsMatrixForY[YRG] = new boolean[] {true,true,false};
        positionsMatrixForY[YRJ] = new boolean[] {true,true,false};
        positionsMatrixForY[YRK] = new boolean[] {true,true,false};
        positionsMatrixForY[YRL] = new boolean[] {true,true,false};
        positionsMatrixForY[YRM] = new boolean[] {true,true,false};
        positionsMatrixForY[YRN] = new boolean[] {true,true,false};
        positionsMatrixForY[YRP] = new boolean[] {true,true,false};
        positionsMatrixForY[YRQ] = new boolean[] {true,true,false};
        positionsMatrixForY[YRR] = new boolean[] {true,true,false};
        positionsMatrixForY[YRS] = new boolean[] {true,true,false};
        positionsMatrixForY[YRT] = new boolean[] {true,true,false};
        positionsMatrixForY[YRV] = new boolean[] {true,true,false};
        positionsMatrixForY[YRY] = new boolean[] {true,true,false};
        positionsMatrixForY[YRZ] = new boolean[] {true,true,false};
        positionsMatrixForY[YSB] = new boolean[] {true,true,false};
        positionsMatrixForY[YSC] = new boolean[] {true,true,false};
        positionsMatrixForY[YSG] = new boolean[] {true,true,false};
        positionsMatrixForY[YSH] = new boolean[] {true,true,false};
        positionsMatrixForY[YSK] = new boolean[] {true,true,false};
        positionsMatrixForY[YSL] = new boolean[] {true,true,false};
        positionsMatrixForY[YSM] = new boolean[] {true,true,false};
        positionsMatrixForY[YSN] = new boolean[] {true,true,false};
        positionsMatrixForY[YSP] = new boolean[] {true,true,false};
        positionsMatrixForY[YSQ] = new boolean[] {true,true,false};
        positionsMatrixForY[YSS] = new boolean[] {true,true,false};
        positionsMatrixForY[YST] = new boolean[] {true,true,false};
        positionsMatrixForY[YSV] = new boolean[] {true,true,false};
        positionsMatrixForY[YSW] = new boolean[] {true,true,false};
        positionsMatrixForY[YSY] = new boolean[] {true,true,false};
        positionsMatrixForY[YTH] = new boolean[] {true,true,false};
        positionsMatrixForY[YTL] = new boolean[] {true,true,false};
        positionsMatrixForY[YTR] = new boolean[] {true,true,false};
        positionsMatrixForY[YTS] = new boolean[] {true,true,false};
        positionsMatrixForY[YTT] = new boolean[] {true,true,false};
        positionsMatrixForY[YTW] = new boolean[] {true,true,false};
        positionsMatrixForY[YTY] = new boolean[] {true,true,false};
        positionsMatrixForY[YTZ] = new boolean[] {true,true,false};
        positionsMatrixForY[YVL] = new boolean[] {true,true,false};
        positionsMatrixForY[YVN] = new boolean[] {true,true,false};
        positionsMatrixForY[YVR] = new boolean[] {true,true,false};
        positionsMatrixForY[YVS] = new boolean[] {true,true,false};
        positionsMatrixForY[YVV] = new boolean[] {true,true,false};
        positionsMatrixForY[YVY] = new boolean[] {true,true,false};
        positionsMatrixForY[YVZ] = new boolean[] {true,true,false};
        positionsMatrixForY[YZB] = new boolean[] {true,true,false};
        positionsMatrixForY[YZC] = new boolean[] {true,true,false};
        positionsMatrixForY[YZD] = new boolean[] {true,true,false};
        positionsMatrixForY[YZF] = new boolean[] {true,true,false};
        positionsMatrixForY[YZG] = new boolean[] {true,true,false};
        positionsMatrixForY[YZK] = new boolean[] {true,true,false};
        positionsMatrixForY[YZN] = new boolean[] {true,true,false};
        positionsMatrixForY[YZY] = new boolean[] {true,true,false};
        positionsMatrixForY[YZZ] = new boolean[] {true,true,false};

        this.positionsMatrixForZ
            = new boolean[getCollectionSizeForZ()][NUMBER_OF_POSITIONS];
        positionsMatrixForZ[ZBB] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZBH] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZBR] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZBY] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZCH] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZCL] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZDD] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZDH] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZDR] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZDW] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZDY] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZFF] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZFL] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZFR] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZGG] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZGH] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZGL] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZGR] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZKH] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZKK] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZKL] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZKR] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZKY] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZNN] = new boolean[] {false,true,false};
        positionsMatrixForZ[ZNY] = new boolean[] {false,true,true};
        positionsMatrixForZ[ZYB] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYL] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYM] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYP] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYR] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYS] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYT] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYV] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZYZ] = new boolean[] {true,true,true};
        positionsMatrixForZ[ZZY] = new boolean[] {false,true,true};
    }

}
