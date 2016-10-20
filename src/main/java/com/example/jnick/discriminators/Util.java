package com.example.jnick.discriminators;

import com.example.jnick.discriminators.exceptions.AlphabetCharacterRequiredException;

/**
 * @author fabian
 */
public class Util {

    private       static boolean[][]   rulesMatrix;
    private final static short
        A =  0, B =  1, C =  2, D =  3, E =  5, F =  6, G =  7, H =  8,
        I =  9, J = 10, K = 11, L = 12, M = 13, N = 14, O = 15, P = 16,
        Q = 17, R = 18, S = 19, T = 20, U = 21, V = 22, W = 23, X = 23,
        Y = 24, Z = 25;

    private final static String VOWEL_TYPE      = "vocal";
    private final static String CONSONANT_TYPE  = "consonant";
    private final static String VOWELS          = "aeiou";
    private final static String CONSONANTS      = "bcdfghjklmnpqrstvwxyz";

    private final static String ALPHABET_CHARACTER_REQIURED_MESSAGE
                                    = "Error: alphabet character required.";


    private Util() {
        initRulesMatrix();
    }


    /**
     * Obtains the type of one character: vowel or consonant.
     *
     * @param   character character to know its type.
     * @return            vowel or consonant.
     * */
    public static String getCharacterType(char character)
            throws AlphabetCharacterRequiredException {
        if(isVowel(character)) {
            return VOWEL_TYPE;
        } else if(isConsonant(character)) {
            return CONSONANT_TYPE;
        } else {
            throw new AlphabetCharacterRequiredException(
                ALPHABET_CHARACTER_REQIURED_MESSAGE,
                character
            );
        }
    }

    /**
     * Checks if a pair of characters both are vowels or consonants.
     *
     * @param   characterOne first character.
     * @param   characterTwo second character.
     * @return               are of the same type or not.
     * */
    public static boolean areSameType(char characterOne, char characterTwo) {
        return isVowel(characterOne)
            && isVowel(characterTwo)
            || isConsonant(characterOne)
            && isConsonant(characterTwo);
    }

    /**
     * Checks if a character can be after another one.
     *
     * @param   character first character.
     * @param   successor second character.
     * @return            can be sequence or not.
     * */
    public static boolean canBeSequence(char character, char successor) {
        return rulesMatrix
            [getCharacterIndex(character)]
            [getCharacterIndex(successor)];
    }

    /**
     * Checks if a character is vowel or not.
     *
     * @param   character character to check.
     * @return            vowel or not vocal.
     * */
    private static boolean isVowel(char character) {
        for(char vowel: VOWELS.toCharArray()) {
            if(character == vowel) return true;
        }
        return false;
    }

    /**
     * Checks if a character is consonant or not.
     *
     * @param   character character to check.
     * @return            consonant or not consonant.
     * */
    private static boolean isConsonant(char character) {
        for(char consonant:CONSONANTS.toCharArray()) {
            if(character == consonant) return true;
        }
        return false;
    }

    /**
     * Obtains the index of one character.
     *
     * @param   character character with unknow index.
     * @return            index for rulesMatrix.
     * */
    private static short getCharacterIndex(char character) {
        switch(character) {
            case 'a': return A;
            case 'b': return B;
            case 'c': return C;
            case 'd': return D;
            case 'e': return E;
            case 'f': return F;
            case 'g': return G;
            case 'h': return H;
            case 'i': return I;
            case 'j': return J;
            case 'k': return K;
            case 'l': return L;
            case 'm': return M;
            case 'n': return N;
            case 'o': return O;
            case 'p': return P;
            case 'q': return Q;
            case 'r': return R;
            case 's': return S;
            case 't': return T;
            case 'u': return U;
            case 'v': return V;
            case 'w': return W;
            case 'x': return X;
            case 'y': return Y;
            case 'z': return Z;
        } throw new AlphabetCharacterRequiredException(
            ALPHABET_CHARACTER_REQIURED_MESSAGE,
            character
        );
    }

    /**
     * Initializes the matrix that contains all rules about that character
     * can be after another one.
     * */
    private static void initRulesMatrix() {
        short matrixBounds =(short) (VOWELS + CONSONANTS).length();

        rulesMatrix = new boolean[matrixBounds][matrixBounds];
        rulesMatrix[A][A] = false;
        rulesMatrix[A][B] = true;
        rulesMatrix[A][C] = true;
        rulesMatrix[A][D] = true;
        rulesMatrix[A][E] = true;
        rulesMatrix[A][F] = true;
        rulesMatrix[A][G] = true;
        rulesMatrix[A][H] = false;
        rulesMatrix[A][I] = true;
        rulesMatrix[A][J] = true;
        rulesMatrix[A][K] = true;
        rulesMatrix[A][L] = true;
        rulesMatrix[A][M] = true;
        rulesMatrix[A][N] = true;
        rulesMatrix[A][O] = false;
        rulesMatrix[A][P] = true;
        rulesMatrix[A][Q] = true;
        rulesMatrix[A][R] = true;
        rulesMatrix[A][S] = true;
        rulesMatrix[A][T] = true;
        rulesMatrix[A][U] = false;
        rulesMatrix[A][V] = true;
        rulesMatrix[A][W] = false;
        rulesMatrix[A][X] = true;
        rulesMatrix[A][Y] = true;
        rulesMatrix[A][Z] = true;

        rulesMatrix[B][A] = true;
        rulesMatrix[B][B] = true;
        rulesMatrix[B][C] = false;
        rulesMatrix[B][D] = false;
        rulesMatrix[B][E] = true;
        rulesMatrix[B][F] = false;
        rulesMatrix[B][G] = false;
        rulesMatrix[B][H] = true;
        rulesMatrix[B][I] = true;
        rulesMatrix[B][J] = false;
        rulesMatrix[B][K] = false;
        rulesMatrix[B][L] = true;
        rulesMatrix[B][M] = false;
        rulesMatrix[B][N] = false;
        rulesMatrix[B][O] = true;
        rulesMatrix[B][P] = false;
        rulesMatrix[B][Q] = false;
        rulesMatrix[B][R] = true;
        rulesMatrix[B][S] = true;
        rulesMatrix[B][T] = false;
        rulesMatrix[B][U] = true;
        rulesMatrix[B][V] = false;
        rulesMatrix[B][W] = false;
        rulesMatrix[B][X] = false;
        rulesMatrix[B][Y] = true;
        rulesMatrix[B][Z] = true;

        rulesMatrix[C][A] = true;
        rulesMatrix[C][B] = false;
        rulesMatrix[C][C] = true;
        rulesMatrix[C][D] = false;
        rulesMatrix[C][E] = true;
        rulesMatrix[C][F] = false;
        rulesMatrix[C][G] = false;
        rulesMatrix[C][H] = true;
        rulesMatrix[C][I] = true;
        rulesMatrix[C][J] = false;
        rulesMatrix[C][K] = false;
        rulesMatrix[C][L] = true;
        rulesMatrix[C][M] = false;
        rulesMatrix[C][N] = false;
        rulesMatrix[C][O] = true;
        rulesMatrix[C][P] = false;
        rulesMatrix[C][Q] = false;
        rulesMatrix[C][R] = true;
        rulesMatrix[C][S] = false;
        rulesMatrix[C][T] = false;
        rulesMatrix[C][U] = true;
        rulesMatrix[C][V] = false;
        rulesMatrix[C][W] = false;
        rulesMatrix[C][X] = false;
        rulesMatrix[C][Y] = false;
        rulesMatrix[C][Z] = false;

        rulesMatrix[D][A] = true;
        rulesMatrix[D][B] = false;
        rulesMatrix[D][C] = false;
        rulesMatrix[D][D] = true;
        rulesMatrix[D][E] = true;
        rulesMatrix[D][F] = false;
        rulesMatrix[D][G] = true;
        rulesMatrix[D][H] = true;
        rulesMatrix[D][I] = true;
        rulesMatrix[D][J] = false;
        rulesMatrix[D][K] = true;
        rulesMatrix[D][L] = false;
        rulesMatrix[D][M] = true;
        rulesMatrix[D][N] = false;
        rulesMatrix[D][O] = true;
        rulesMatrix[D][P] = false;
        rulesMatrix[D][Q] = false;
        rulesMatrix[D][R] = true;
        rulesMatrix[D][S] = true;
        rulesMatrix[D][T] = false;
        rulesMatrix[D][U] = true;
        rulesMatrix[D][V] = false;
        rulesMatrix[D][W] = true;
        rulesMatrix[D][X] = false;
        rulesMatrix[D][Y] = true;
        rulesMatrix[D][Z] = false;

        rulesMatrix[E][A] = true;
        rulesMatrix[E][B] = true;
        rulesMatrix[E][C] = true;
        rulesMatrix[E][D] = true;
        rulesMatrix[E][E] = false;
        rulesMatrix[E][F] = true;
        rulesMatrix[E][G] = true;
        rulesMatrix[E][H] = false;
        rulesMatrix[E][I] = true;
        rulesMatrix[E][J] = true;
        rulesMatrix[E][K] = true;
        rulesMatrix[E][L] = true;
        rulesMatrix[E][M] = true;
        rulesMatrix[E][N] = true;
        rulesMatrix[E][O] = true;
        rulesMatrix[E][P] = true;
        rulesMatrix[E][Q] = true;
        rulesMatrix[E][R] = true;
        rulesMatrix[E][S] = true;
        rulesMatrix[E][T] = true;
        rulesMatrix[E][U] = true;
        rulesMatrix[E][V] = true;
        rulesMatrix[E][W] = true;
        rulesMatrix[E][X] = true;
        rulesMatrix[E][Y] = true;
        rulesMatrix[E][Z] = true;

        rulesMatrix[F][A] = true;
        rulesMatrix[F][B] = false;
        rulesMatrix[F][C] = false;
        rulesMatrix[F][D] = false;
        rulesMatrix[F][E] = true;
        rulesMatrix[F][F] = true;
        rulesMatrix[F][G] = false;
        rulesMatrix[F][H] = false;
        rulesMatrix[F][I] = true;
        rulesMatrix[F][J] = false;
        rulesMatrix[F][K] = false;
        rulesMatrix[F][L] = true;
        rulesMatrix[F][M] = false;
        rulesMatrix[F][N] = true;
        rulesMatrix[F][O] = true;
        rulesMatrix[F][P] = false;
        rulesMatrix[F][Q] = false;
        rulesMatrix[F][R] = true;
        rulesMatrix[F][S] = true;
        rulesMatrix[F][T] = false;
        rulesMatrix[F][U] = true;
        rulesMatrix[F][V] = false;
        rulesMatrix[F][W] = false;
        rulesMatrix[F][X] = false;
        rulesMatrix[F][Y] = false;
        rulesMatrix[F][Z] = true;

        rulesMatrix[G][A] = true;
        rulesMatrix[G][B] = false;
        rulesMatrix[G][C] = false;
        rulesMatrix[G][D] = false;
        rulesMatrix[G][E] = true;
        rulesMatrix[G][F] = false;
        rulesMatrix[G][G] = true;
        rulesMatrix[G][H] = true;
        rulesMatrix[G][I] = true;
        rulesMatrix[G][J] = false;
        rulesMatrix[G][K] = false;
        rulesMatrix[G][L] = true;
        rulesMatrix[G][M] = true;
        rulesMatrix[G][N] = false;
        rulesMatrix[G][O] = true;
        rulesMatrix[G][P] = false;
        rulesMatrix[G][Q] = false;
        rulesMatrix[G][R] = true;
        rulesMatrix[G][S] = false;
        rulesMatrix[G][T] = false;
        rulesMatrix[G][U] = true;
        rulesMatrix[G][V] = false;
        rulesMatrix[G][W] = false;
        rulesMatrix[G][X] = false;
        rulesMatrix[G][Y] = false;
        rulesMatrix[G][Z] = false;

        rulesMatrix[H][A] = true;
        rulesMatrix[H][B] = false;
        rulesMatrix[H][C] = false;
        rulesMatrix[H][D] = false;
        rulesMatrix[H][E] = true;
        rulesMatrix[H][F] = false;
        rulesMatrix[H][G] = false;
        rulesMatrix[H][H] = false;
        rulesMatrix[H][I] = true;
        rulesMatrix[H][J] = false;
        rulesMatrix[H][K] = false;
        rulesMatrix[H][L] = false;
        rulesMatrix[H][M] = false;
        rulesMatrix[H][N] = false;
        rulesMatrix[H][O] = true;
        rulesMatrix[H][P] = false;
        rulesMatrix[H][Q] = false;
        rulesMatrix[H][R] = false;
        rulesMatrix[H][S] = false;
        rulesMatrix[H][T] = false;
        rulesMatrix[H][U] = true;
        rulesMatrix[H][V] = false;
        rulesMatrix[H][W] = true;
        rulesMatrix[H][X] = false;
        rulesMatrix[H][Y] = true;
        rulesMatrix[H][Z] = false;

        rulesMatrix[I][A] = true;
        rulesMatrix[I][B] = true;
        rulesMatrix[I][C] = true;
        rulesMatrix[I][D] = true;
        rulesMatrix[I][E] = true;
        rulesMatrix[I][F] = true;
        rulesMatrix[I][G] = true;
        rulesMatrix[I][H] = false;
        rulesMatrix[I][I] = false;
        rulesMatrix[I][J] = true;
        rulesMatrix[I][K] = true;
        rulesMatrix[I][L] = true;
        rulesMatrix[I][M] = true;
        rulesMatrix[I][N] = true;
        rulesMatrix[I][O] = true;
        rulesMatrix[I][P] = true;
        rulesMatrix[I][Q] = false;
        rulesMatrix[I][R] = true;
        rulesMatrix[I][S] = true;
        rulesMatrix[I][T] = true;
        rulesMatrix[I][U] = false;
        rulesMatrix[I][V] = true;
        rulesMatrix[I][W] = true;
        rulesMatrix[I][X] = true;
        rulesMatrix[I][Y] = false;
        rulesMatrix[I][Z] = true;

        rulesMatrix[J][A] = true;
        rulesMatrix[J][B] = false;
        rulesMatrix[J][C] = false;
        rulesMatrix[J][D] = false;
        rulesMatrix[J][E] = true;
        rulesMatrix[J][F] = false;
        rulesMatrix[J][G] = false;
        rulesMatrix[J][H] = false;
        rulesMatrix[J][I] = true;
        rulesMatrix[J][J] = false;
        rulesMatrix[J][K] = false;
        rulesMatrix[J][L] = false;
        rulesMatrix[J][M] = false;
        rulesMatrix[J][N] = false;
        rulesMatrix[J][O] = true;
        rulesMatrix[J][P] = false;
        rulesMatrix[J][Q] = false;
        rulesMatrix[J][R] = false;
        rulesMatrix[J][S] = false;
        rulesMatrix[J][T] = false;
        rulesMatrix[J][U] = true;
        rulesMatrix[J][V] = false;
        rulesMatrix[J][W] = true;
        rulesMatrix[J][X] = false;
        rulesMatrix[J][Y] = false;
        rulesMatrix[J][Z] = false;

        rulesMatrix[K][A] = true;
        rulesMatrix[K][B] = false;
        rulesMatrix[K][C] = false;
        rulesMatrix[K][D] = false;
        rulesMatrix[K][E] = true;
        rulesMatrix[K][F] = false;
        rulesMatrix[K][G] = false;
        rulesMatrix[K][H] = true;
        rulesMatrix[K][I] = true;
        rulesMatrix[K][J] = false;
        rulesMatrix[K][K] = true;
        rulesMatrix[K][L] = true;
        rulesMatrix[K][M] = false;
        rulesMatrix[K][N] = true;
        rulesMatrix[K][O] = true;
        rulesMatrix[K][P] = false;
        rulesMatrix[K][Q] = false;
        rulesMatrix[K][R] = true;
        rulesMatrix[K][S] = true;
        rulesMatrix[K][T] = false;
        rulesMatrix[K][U] = true;
        rulesMatrix[K][V] = false;
        rulesMatrix[K][W] = false;
        rulesMatrix[K][X] = false;
        rulesMatrix[K][Y] = true;
        rulesMatrix[K][Z] = false;

        rulesMatrix[L][A] = true;
        rulesMatrix[L][B] = true;
        rulesMatrix[L][C] = true;
        rulesMatrix[L][D] = true;
        rulesMatrix[L][E] = true;
        rulesMatrix[L][F] = true;
        rulesMatrix[L][G] = true;
        rulesMatrix[L][H] = false;
        rulesMatrix[L][I] = true;
        rulesMatrix[L][J] = false;
        rulesMatrix[L][K] = true;
        rulesMatrix[L][L] = true;
        rulesMatrix[L][M] = true;
        rulesMatrix[L][N] = false;
        rulesMatrix[L][O] = true;
        rulesMatrix[L][P] = false;
        rulesMatrix[L][Q] = false;
        rulesMatrix[L][R] = false;
        rulesMatrix[L][S] = true;
        rulesMatrix[L][T] = true;
        rulesMatrix[L][U] = true;
        rulesMatrix[L][V] = false;
        rulesMatrix[L][W] = true;
        rulesMatrix[L][X] = false;
        rulesMatrix[L][Y] = true;
        rulesMatrix[L][Z] = true;

        rulesMatrix[M][A] = true;
        rulesMatrix[M][B] = true;
        rulesMatrix[M][C] = false;
        rulesMatrix[M][D] = false;
        rulesMatrix[M][E] = true;
        rulesMatrix[M][F] = false;
        rulesMatrix[M][G] = false;
        rulesMatrix[M][H] = false;
        rulesMatrix[M][I] = true;
        rulesMatrix[M][J] = false;
        rulesMatrix[M][K] = false;
        rulesMatrix[M][L] = false;
        rulesMatrix[M][M] = false;
        rulesMatrix[M][N] = false;
        rulesMatrix[M][O] = true;
        rulesMatrix[M][P] = false;
        rulesMatrix[M][Q] = false;
        rulesMatrix[M][R] = false;
        rulesMatrix[M][S] = false;
        rulesMatrix[M][T] = false;
        rulesMatrix[M][U] = true;
        rulesMatrix[M][V] = false;
        rulesMatrix[M][W] = false;
        rulesMatrix[M][X] = false;
        rulesMatrix[M][Y] = true;
        rulesMatrix[M][Z] = false;

        rulesMatrix[N][A] = true;
        rulesMatrix[N][B] = true;
        rulesMatrix[N][C] = true;
        rulesMatrix[N][D] = true;
        rulesMatrix[N][E] = true;
        rulesMatrix[N][F] = true;
        rulesMatrix[N][G] = true;
        rulesMatrix[N][H] = false;
        rulesMatrix[N][I] = true;
        rulesMatrix[N][J] = false;
        rulesMatrix[N][K] = true;
        rulesMatrix[N][L] = false;
        rulesMatrix[N][M] = false;
        rulesMatrix[N][N] = true;
        rulesMatrix[N][O] = true;
        rulesMatrix[N][P] = true;
        rulesMatrix[N][Q] = true;
        rulesMatrix[N][R] = false;
        rulesMatrix[N][S] = true;
        rulesMatrix[N][T] = true;
        rulesMatrix[N][U] = true;
        rulesMatrix[N][V] = false;
        rulesMatrix[N][W] = false;
        rulesMatrix[N][X] = true;
        rulesMatrix[N][Y] = true;
        rulesMatrix[N][Z] = true;

        rulesMatrix[O][A] = false;
        rulesMatrix[O][B] = true;
        rulesMatrix[O][C] = true;
        rulesMatrix[O][D] = true;
        rulesMatrix[O][E] = true;
        rulesMatrix[O][F] = true;
        rulesMatrix[O][G] = true;
        rulesMatrix[O][H] = false;
        rulesMatrix[O][I] = false;
        rulesMatrix[O][J] = true;
        rulesMatrix[O][K] = true;
        rulesMatrix[O][L] = true;
        rulesMatrix[O][M] = true;
        rulesMatrix[O][N] = true;
        rulesMatrix[O][O] = true;
        rulesMatrix[O][P] = true;
        rulesMatrix[O][Q] = false;
        rulesMatrix[O][R] = true;
        rulesMatrix[O][S] = true;
        rulesMatrix[O][T] = true;
        rulesMatrix[O][U] = false;
        rulesMatrix[O][V] = true;
        rulesMatrix[O][W] = true;
        rulesMatrix[O][X] = true;
        rulesMatrix[O][Y] = false;
        rulesMatrix[O][Z] = true;

        rulesMatrix[P][A] = true;
        rulesMatrix[P][B] = false;
        rulesMatrix[P][C] = false;
        rulesMatrix[P][D] = false;
        rulesMatrix[P][E] = true;
        rulesMatrix[P][F] = false;
        rulesMatrix[P][G] = false;
        rulesMatrix[P][H] = true;
        rulesMatrix[P][I] = true;
        rulesMatrix[P][J] = false;
        rulesMatrix[P][K] = false;
        rulesMatrix[P][L] = true;
        rulesMatrix[P][M] = false;
        rulesMatrix[P][N] = true;
        rulesMatrix[P][O] = true;
        rulesMatrix[P][P] = true;
        rulesMatrix[P][Q] = false;
        rulesMatrix[P][R] = true;
        rulesMatrix[P][S] = true;
        rulesMatrix[P][T] = true;
        rulesMatrix[P][U] = true;
        rulesMatrix[P][V] = false;
        rulesMatrix[P][W] = false;
        rulesMatrix[P][X] = true;
        rulesMatrix[P][Y] = true;
        rulesMatrix[P][Z] = false;

        rulesMatrix[Q][A] = false;
        rulesMatrix[Q][B] = false;
        rulesMatrix[Q][C] = false;
        rulesMatrix[Q][D] = false;
        rulesMatrix[Q][E] = false;
        rulesMatrix[Q][F] = false;
        rulesMatrix[Q][G] = false;
        rulesMatrix[Q][H] = false;
        rulesMatrix[Q][I] = false;
        rulesMatrix[Q][J] = false;
        rulesMatrix[Q][K] = false;
        rulesMatrix[Q][L] = false;
        rulesMatrix[Q][M] = false;
        rulesMatrix[Q][N] = false;
        rulesMatrix[Q][O] = false;
        rulesMatrix[Q][P] = false;
        rulesMatrix[Q][Q] = false;
        rulesMatrix[Q][R] = false;
        rulesMatrix[Q][S] = false;
        rulesMatrix[Q][T] = false;
        rulesMatrix[Q][U] = true;
        rulesMatrix[Q][V] = false;
        rulesMatrix[Q][W] = false;
        rulesMatrix[Q][X] = false;
        rulesMatrix[Q][Y] = false;
        rulesMatrix[Q][Z] = false;

        rulesMatrix[R][A] = true;
        rulesMatrix[R][B] = true;
        rulesMatrix[R][C] = true;
        rulesMatrix[R][D] = true;
        rulesMatrix[R][E] = true;
        rulesMatrix[R][F] = true;
        rulesMatrix[R][G] = true;
        rulesMatrix[R][H] = false;
        rulesMatrix[R][I] = true;
        rulesMatrix[R][J] = true;
        rulesMatrix[R][K] = true;
        rulesMatrix[R][L] = true;
        rulesMatrix[R][M] = true;
        rulesMatrix[R][N] = true;
        rulesMatrix[R][O] = true;
        rulesMatrix[R][P] = true;
        rulesMatrix[R][Q] = true;
        rulesMatrix[R][R] = true;
        rulesMatrix[R][S] = true;
        rulesMatrix[R][T] = true;
        rulesMatrix[R][U] = true;
        rulesMatrix[R][V] = true;
        rulesMatrix[R][W] = false;
        rulesMatrix[R][X] = false;
        rulesMatrix[R][Y] = true;
        rulesMatrix[R][Z] = true;

        rulesMatrix[S][A] = true;
        rulesMatrix[S][B] = true;
        rulesMatrix[S][C] = true;
        rulesMatrix[S][D] = false;
        rulesMatrix[S][E] = true;
        rulesMatrix[S][F] = false;
        rulesMatrix[S][G] = true;
        rulesMatrix[S][H] = true;
        rulesMatrix[S][I] = true;
        rulesMatrix[S][J] = false;
        rulesMatrix[S][K] = true;
        rulesMatrix[S][L] = true;
        rulesMatrix[S][M] = true;
        rulesMatrix[S][N] = true;
        rulesMatrix[S][O] = true;
        rulesMatrix[S][P] = true;
        rulesMatrix[S][Q] = true;
        rulesMatrix[S][R] = false;
        rulesMatrix[S][S] = true;
        rulesMatrix[S][T] = true;
        rulesMatrix[S][U] = true;
        rulesMatrix[S][V] = true;
        rulesMatrix[S][W] = true;
        rulesMatrix[S][X] = false;
        rulesMatrix[S][Y] = true;
        rulesMatrix[S][Z] = false;

        rulesMatrix[T][A] = true;
        rulesMatrix[T][B] = false;
        rulesMatrix[T][C] = false;
        rulesMatrix[T][D] = false;
        rulesMatrix[T][E] = true;
        rulesMatrix[T][F] = false;
        rulesMatrix[T][G] = false;
        rulesMatrix[T][H] = true;
        rulesMatrix[T][I] = true;
        rulesMatrix[T][J] = false;
        rulesMatrix[T][K] = false;
        rulesMatrix[T][L] = true;
        rulesMatrix[T][M] = false;
        rulesMatrix[T][N] = false;
        rulesMatrix[T][O] = true;
        rulesMatrix[T][P] = false;
        rulesMatrix[T][Q] = false;
        rulesMatrix[T][R] = true;
        rulesMatrix[T][S] = true;
        rulesMatrix[T][T] = true;
        rulesMatrix[T][U] = true;
        rulesMatrix[T][V] = false;
        rulesMatrix[T][W] = true;
        rulesMatrix[T][X] = false;
        rulesMatrix[T][Y] = true;
        rulesMatrix[T][Z] = true;

        rulesMatrix[U][A] = true;
        rulesMatrix[U][B] = true;
        rulesMatrix[U][C] = true;
        rulesMatrix[U][D] = true;
        rulesMatrix[U][E] = true;
        rulesMatrix[U][F] = true;
        rulesMatrix[U][G] = true;
        rulesMatrix[U][H] = false;
        rulesMatrix[U][I] = true;
        rulesMatrix[U][J] = true;
        rulesMatrix[U][K] = true;
        rulesMatrix[U][L] = true;
        rulesMatrix[U][M] = true;
        rulesMatrix[U][N] = true;
        rulesMatrix[U][O] = true;
        rulesMatrix[U][P] = true;
        rulesMatrix[U][Q] = false;
        rulesMatrix[U][R] = true;
        rulesMatrix[U][S] = true;
        rulesMatrix[U][T] = true;
        rulesMatrix[U][U] = false;
        rulesMatrix[U][V] = true;
        rulesMatrix[U][W] = false;
        rulesMatrix[U][X] = true;
        rulesMatrix[U][Y] = false;
        rulesMatrix[U][Z] = true;

        rulesMatrix[V][A] = true;
        rulesMatrix[V][B] = false;
        rulesMatrix[V][C] = false;
        rulesMatrix[V][D] = false;
        rulesMatrix[V][E] = true;
        rulesMatrix[V][F] = false;
        rulesMatrix[V][G] = false;
        rulesMatrix[V][H] = false;
        rulesMatrix[V][I] = true;
        rulesMatrix[V][J] = false;
        rulesMatrix[V][K] = false;
        rulesMatrix[V][L] = true;
        rulesMatrix[V][M] = false;
        rulesMatrix[V][N] = true;
        rulesMatrix[V][O] = true;
        rulesMatrix[V][P] = false;
        rulesMatrix[V][Q] = false;
        rulesMatrix[V][R] = true;
        rulesMatrix[V][S] = true;
        rulesMatrix[V][T] = false;
        rulesMatrix[V][U] = true;
        rulesMatrix[V][V] = true;
        rulesMatrix[V][W] = false;
        rulesMatrix[V][X] = false;
        rulesMatrix[V][Y] = true;
        rulesMatrix[V][Z] = true;

        rulesMatrix[W][A] = true;
        rulesMatrix[W][B] = false;
        rulesMatrix[W][C] = true;
        rulesMatrix[W][D] = false;
        rulesMatrix[W][E] = true;
        rulesMatrix[W][F] = false;
        rulesMatrix[W][G] = true;
        rulesMatrix[W][H] = false;
        rulesMatrix[W][I] = true;
        rulesMatrix[W][J] = false;
        rulesMatrix[W][K] = true;
        rulesMatrix[W][L] = false;
        rulesMatrix[W][M] = true;
        rulesMatrix[W][N] = false;
        rulesMatrix[W][O] = false;
        rulesMatrix[W][P] = false;
        rulesMatrix[W][Q] = false;
        rulesMatrix[W][R] = false;
        rulesMatrix[W][S] = false;
        rulesMatrix[W][T] = true;
        rulesMatrix[W][U] = false;
        rulesMatrix[W][V] = false;
        rulesMatrix[W][W] = false;
        rulesMatrix[W][X] = true;
        rulesMatrix[W][Y] = false;
        rulesMatrix[W][Z] = false;

        rulesMatrix[X][A] = true;
        rulesMatrix[X][B] = false;
        rulesMatrix[X][C] = false;
        rulesMatrix[X][D] = false;
        rulesMatrix[X][E] = true;
        rulesMatrix[X][F] = false;
        rulesMatrix[X][G] = false;
        rulesMatrix[X][H] = false;
        rulesMatrix[X][I] = true;
        rulesMatrix[X][J] = false;
        rulesMatrix[X][K] = false;
        rulesMatrix[X][L] = false;
        rulesMatrix[X][M] = false;
        rulesMatrix[X][N] = false;
        rulesMatrix[X][O] = true;
        rulesMatrix[X][P] = false;
        rulesMatrix[X][Q] = false;
        rulesMatrix[X][R] = false;
        rulesMatrix[X][S] = false;
        rulesMatrix[X][T] = true;
        rulesMatrix[X][U] = true;
        rulesMatrix[X][V] = false;
        rulesMatrix[X][W] = false;
        rulesMatrix[X][X] = true;
        rulesMatrix[X][Y] = false;
        rulesMatrix[X][Z] = false;

        rulesMatrix[Y][A] = true;
        rulesMatrix[Y][B] = true;
        rulesMatrix[Y][C] = false;
        rulesMatrix[Y][D] = true;
        rulesMatrix[Y][E] = true;
        rulesMatrix[Y][F] = false;
        rulesMatrix[Y][G] = false;
        rulesMatrix[Y][H] = false;
        rulesMatrix[Y][I] = false;
        rulesMatrix[Y][J] = false;
        rulesMatrix[Y][K] = false;
        rulesMatrix[Y][L] = true;
        rulesMatrix[Y][M] = true;
        rulesMatrix[Y][N] = false;
        rulesMatrix[Y][O] = true;
        rulesMatrix[Y][P] = true;
        rulesMatrix[Y][Q] = false;
        rulesMatrix[Y][R] = true;
        rulesMatrix[Y][S] = true;
        rulesMatrix[Y][T] = true;
        rulesMatrix[Y][U] = false;
        rulesMatrix[Y][V] = true;
        rulesMatrix[Y][W] = false;
        rulesMatrix[Y][X] = false;
        rulesMatrix[Y][Y] = false;
        rulesMatrix[Y][Z] = true;

        rulesMatrix[Z][A] = true;
        rulesMatrix[Z][B] = true;
        rulesMatrix[Z][C] = true;
        rulesMatrix[Z][D] = true;
        rulesMatrix[Z][E] = true;
        rulesMatrix[Z][F] = true;
        rulesMatrix[Z][G] = true;
        rulesMatrix[Z][H] = false;
        rulesMatrix[Z][I] = true;
        rulesMatrix[Z][J] = false;
        rulesMatrix[Z][K] = true;
        rulesMatrix[Z][L] = false;
        rulesMatrix[Z][M] = false;
        rulesMatrix[Z][N] = true;
        rulesMatrix[Z][O] = true;
        rulesMatrix[Z][P] = false;
        rulesMatrix[Z][Q] = false;
        rulesMatrix[Z][R] = false;
        rulesMatrix[Z][S] = false;
        rulesMatrix[Z][T] = false;
        rulesMatrix[Z][U] = true;
        rulesMatrix[Z][V] = false;
        rulesMatrix[Z][W] = false;
        rulesMatrix[Z][X] = false;
        rulesMatrix[Z][Y] = true;
        rulesMatrix[Z][Z] = true;
    }

}
