package com.example.toshiba.yaleastemari;

public abstract class SoundPath {
   public static int[] englishLettersSound = new int[]{
           R.raw.s1,R.raw.s2,R.raw.s3,R.raw.s4,R.raw.s5,R.raw.s6,
           R.raw.s7,R.raw.s8,R.raw.s9,R.raw.s10,R.raw.s11,R.raw.s12,
           R.raw.s13,R.raw.s14,R.raw.s15,R.raw.s16,R.raw.s17,R.raw.s18,
           R.raw.s19,R.raw.s20,R.raw.s21,R.raw.s22,R.raw.s23,R.raw.s24,R.raw.s25,R.raw.s26,};

   public static int[] amharicLettersImageSound = new int[]{R.raw.he,R.raw.le,R.raw.hhe,R.raw.me,
           R.raw.se,R.raw.null_sound,R.raw.sse,R.raw.xe,R.raw.qe,
           R.raw.be,R.raw.null_sound,R.raw.te,R.raw.che,R.raw.he,
           R.raw.ne,R.raw.null_sound,R.raw.a,R.raw.ke,R.raw.null_sound,R.raw.we,R.raw.aa,
           R.raw.ze,R.raw.zze,R.raw.null_sound,R.raw.de,R.raw.je,R.raw.ge,
           R.raw.tte,R.raw.cce,R.raw.ppe,R.raw.tse,R.raw.tzse,R.raw.fe,R.raw.pe};

   public static int[] numbersSound = new int[]{
           R.raw.sn1,R.raw.sn2,R.raw.sn3,R.raw.sn4,R.raw.sn5,R.raw.sn6,R.raw.sn7,R.raw.sn8,R.raw.sn9,R.raw.sn10,
           R.raw.sn11,R.raw.sn12,R.raw.sn13,R.raw.sn14,R.raw.sn15,R.raw.sn16,R.raw.sn17,R.raw.sn18,R.raw.sn19,R.raw.sn20,
   };

   public static int[][] amharicLettersSoundPath = new int[][]{

        {R.raw.sound_1_1,R.raw.sound_1_2,R.raw.sound_1_3,R.raw.sound_1_4,R.raw.sound_1_5,R.raw.sound_1_6,R.raw.sound_1_7},//ሀ
        {R.raw.sound_2_1,R.raw.sound_2_2,R.raw.sound_2_3,R.raw.sound_2_4,R.raw.sound_2_5,R.raw.sound_2_6,R.raw.sound_2_7},//ለ
        {R.raw.sound_3_1,R.raw.sound_3_2,R.raw.sound_3_3,R.raw.sound_3_4,R.raw.sound_3_5,R.raw.sound_3_6,R.raw.sound_3_7},//ሐ
        {R.raw.sound_4_1,R.raw.sound_4_2,R.raw.sound_4_3,R.raw.sound_4_4,R.raw.sound_4_5,R.raw.sound_4_6,R.raw.sound_4_7},//መ
        {R.raw.sound_5_1,R.raw.sound_5_2,R.raw.sound_5_3,R.raw.sound_5_4,R.raw.sound_5_5,R.raw.sound_5_6,R.raw.sound_5_7},//ሠ
        {R.raw.sound_6_1,R.raw.sound_6_2,R.raw.sound_6_3,R.raw.sound_6_4,R.raw.sound_6_5,R.raw.sound_6_6,R.raw.sound_6_7},//ረ
        {R.raw.sound_7_1,R.raw.sound_7_2,R.raw.sound_7_3,R.raw.sound_7_4,R.raw.sound_7_5,R.raw.sound_7_6,R.raw.sound_7_7},//ሰ
        {R.raw.sound_8_1,R.raw.sound_8_2,R.raw.sound_8_3,R.raw.sound_8_4,R.raw.sound_8_5,R.raw.sound_8_6,R.raw.sound_8_7},//ሸ
        {R.raw.sound_9_1,R.raw.sound_9_2,R.raw.sound_9_3,R.raw.sound_9_4,R.raw.sound_9_5,R.raw.sound_9_6,R.raw.sound_9_7},//ቀ
        {R.raw.sound_10_1,R.raw.sound_10_2,R.raw.sound_10_3,R.raw.sound_10_4,R.raw.sound_10_5,R.raw.sound_10_6,R.raw.sound_10_7},//በ
        {R.raw.sound_11_1,R.raw.sound_11_2,R.raw.sound_11_3,R.raw.sound_11_4,R.raw.sound_11_5,R.raw.sound_11_6,R.raw.sound_11_7},//ቨ
        {R.raw.sound_12_1,R.raw.sound_12_2,R.raw.sound_12_3,R.raw.sound_12_4,R.raw.sound_12_5,R.raw.sound_12_6,R.raw.sound_12_7},//ተ
        {R.raw.sound_13_1,R.raw.sound_13_2,R.raw.sound_13_3,R.raw.sound_13_4,R.raw.sound_13_5,R.raw.sound_13_6,R.raw.sound_13_7},//ቸ
        {R.raw.sound_14_1,R.raw.sound_14_2,R.raw.sound_14_3,R.raw.sound_14_4,R.raw.sound_14_5,R.raw.sound_14_6,R.raw.sound_14_7},//ኀ
        {R.raw.sound_15_1,R.raw.sound_15_2,R.raw.sound_15_3,R.raw.sound_15_4,R.raw.sound_15_5,R.raw.sound_15_6,R.raw.sound_15_7},//ነ
        {R.raw.sound_16_1,R.raw.sound_16_2,R.raw.sound_16_3,R.raw.sound_16_4,R.raw.sound_16_5,R.raw.sound_16_6,R.raw.sound_16_7},//ኘ
        {R.raw.sound_17_1,R.raw.sound_17_2,R.raw.sound_17_3,R.raw.sound_17_4,R.raw.sound_17_5,R.raw.sound_17_6,R.raw.sound_17_7},//አ
        {R.raw.sound_18_1,R.raw.sound_18_2,R.raw.sound_18_3,R.raw.sound_18_4,R.raw.sound_18_5,R.raw.sound_18_6,R.raw.sound_18_7},//ከ
        {R.raw.sound_19_1,R.raw.sound_19_2,R.raw.sound_19_3,R.raw.sound_19_4,R.raw.sound_19_5,R.raw.sound_19_6,R.raw.sound_19_7},//ኸ
        {R.raw.sound_20_1,R.raw.sound_20_2,R.raw.sound_20_3,R.raw.sound_20_4,R.raw.sound_20_5,R.raw.sound_20_6,R.raw.sound_20_7},//ወ
        {R.raw.sound_21_1,R.raw.sound_21_2,R.raw.sound_21_3,R.raw.sound_21_4,R.raw.sound_21_5,R.raw.sound_21_6,R.raw.sound_21_7},//ዐ
        {R.raw.sound_22_1,R.raw.sound_22_2,R.raw.sound_22_3,R.raw.sound_22_4,R.raw.sound_22_5,R.raw.sound_22_6,R.raw.sound_22_7},//ዘ
        {R.raw.sound_23_1,R.raw.sound_23_2,R.raw.sound_23_3,R.raw.sound_23_4,R.raw.sound_23_5,R.raw.sound_23_6,R.raw.sound_23_7},//ዠ
        {R.raw.sound_24_1,R.raw.sound_24_2,R.raw.sound_24_3,R.raw.sound_24_4,R.raw.sound_24_5,R.raw.sound_24_6,R.raw.sound_24_7},//የ
        {R.raw.sound_25_1,R.raw.sound_25_2,R.raw.sound_25_3,R.raw.sound_25_4,R.raw.sound_25_5,R.raw.sound_25_6,R.raw.sound_25_7},//ደ
        {R.raw.sound_26_1,R.raw.sound_26_2,R.raw.sound_26_3,R.raw.sound_26_4,R.raw.sound_26_5,R.raw.sound_26_6,R.raw.sound_26_7},//ጀ
        {R.raw.sound_27_1,R.raw.sound_27_2,R.raw.sound_27_3,R.raw.sound_27_4,R.raw.sound_27_5,R.raw.sound_27_6,R.raw.sound_27_7},//ገ
        {R.raw.sound_28_1,R.raw.sound_28_2,R.raw.sound_28_3,R.raw.sound_28_4,R.raw.sound_28_5,R.raw.sound_28_6,R.raw.sound_28_7},//ጠ
        {R.raw.sound_29_1,R.raw.sound_29_2,R.raw.sound_29_3,R.raw.sound_29_4,R.raw.sound_29_5,R.raw.sound_29_6,R.raw.sound_29_7},//ጨ
        {R.raw.sound_30_1,R.raw.sound_30_2,R.raw.sound_30_3,R.raw.sound_30_4,R.raw.sound_30_5,R.raw.sound_30_6,R.raw.sound_30_7},//ጰ
        {R.raw.sound_31_1,R.raw.sound_31_2,R.raw.sound_31_3,R.raw.sound_31_4,R.raw.sound_31_5,R.raw.sound_31_6,R.raw.sound_31_7},//ጸ
        {R.raw.sound_32_1,R.raw.sound_32_2,R.raw.sound_32_3,R.raw.sound_32_4,R.raw.sound_32_5,R.raw.sound_32_6,R.raw.sound_32_7},//ፀ
        {R.raw.sound_33_1,R.raw.sound_33_2,R.raw.sound_33_3,R.raw.sound_33_4,R.raw.sound_33_5,R.raw.sound_33_6,R.raw.sound_33_7},//ፈ
        {R.raw.sound_34_1,R.raw.sound_34_2,R.raw.sound_34_3,R.raw.sound_34_4,R.raw.sound_34_5,R.raw.sound_34_6,R.raw.sound_34_7},//ፐ
   };
   public static int[][] selectedQuestionLettersSound = new int[][]{
           //level 1 sounds
           {R.raw.sound_1_1,R.raw.sound_10_1,R.raw.sound_18_1,R.raw.sound_2_1,R.raw.sound_22_1},
           {R.raw.sound_1_6,R.raw.sound_29_1,R.raw.sound_4_1,R.raw.sound_33_1,R.raw.sound_20_2},
           {R.raw.sound_10_7,R.raw.sound_12_4,R.raw.sound_25_6,R.raw.sound_18_2,R.raw.sound_26_7},
           {R.raw.sound_33_2,R.raw.sound_5_7,R.raw.sound_6_4,R.raw.sound_31_6,R.raw.sound_13_7},
           {R.raw.sound_21_4,R.raw.sound_15_6,R.raw.sound_12_7,R.raw.sound_23_6,R.raw.sound_9_7},
           {R.raw.sound_34_7,R.raw.sound_29_5,R.raw.sound_24_3,R.raw.sound_14_7,R.raw.sound_32_7},

   };



}
