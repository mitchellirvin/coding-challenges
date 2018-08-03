// https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming

public class Abbreviation {
    // Complete the abbreviation function below.
    static String abbreviationRecursive(String a, String b) {
        if (a.length() < b.length()) {
            return "NO";
        }

        return isAbbreviation(a, b, 0, 0) ? "YES" : "NO";
    }

    static boolean isAbbreviation(String a, String b, int indexA, int indexB) {
        // printTabs(indexA);
        // base cases
        if (indexB >= b.length()) {
            // ensure rest of a is non-cap and can be trimmed
            while (indexA < a.length()) {
                if (!isLowercase(a.charAt(indexA))) {
                    return false;
                }
                indexA++;
            }
            // System.out.println("Discovered a winner!");
            return true;
        } else if (indexA >= a.length() && indexB < b.length()) {
            return false;
        }

        char charAtIndexA = a.charAt(indexA);
        char charAtIndexB = b.charAt(indexB);
        // System.out.println(charAtIndexA + ", " + charAtIndexB);

        // if we can't remove or capitalize current character
        if (!isEqualIgnoresCase(charAtIndexA, charAtIndexB) && !isLowercase(charAtIndexA)) {
            // System.out.println("Can't remove or capitalize: " + charAtIndexA + ", " + charAtIndexB);
            return false;
        }

        // return OR of both paths, remove or capitalize
        boolean canBeConverted = false;

        // if can be converted to uppercase, explore capitalizing
        if (isEqualIgnoresCase(charAtIndexA, charAtIndexB)) {
            // System.out.println("exploring uppercase: " + charAtIndexA);
            canBeConverted |= isAbbreviation(a, b, indexA + 1, indexB + 1);
        }
        // explore removing
        if (isLowercase(charAtIndexA)) {
            // System.out.println("exploring removing: " + charAtIndexA);
            canBeConverted |= isAbbreviation(a, b, indexA + 1, indexB);
        }

        return canBeConverted;
    }

    static void printTabs(int n) {
        while (n >= 0) {
            System.out.print("    ");
            n--;
        }
    }

    static boolean isEqualIgnoresCase(char a, char b) {
        return (a == b || Character.toUpperCase(a) == b);
    }

    static boolean isEqualLowerToUpperCase(char a, char b) {
        return (isLowercase(a) && Character.toUpperCase(a) == b);
    }

    static boolean isLowercase(char c) {
        return (c <= 122 && c >= 97);
    }

    static boolean isUppercase(char c) {
        return (c <= 90 && c >= 65);
    }

    static String abbreviationDP(String a, String b) {
        int[][] dp = generateDp(a, b);

        for (int indexA = 1; indexA <= a.length(); indexA++) {
            for (int indexB = 1; indexB <= b.length(); indexB++) {
                char charAtIndexA = a.charAt(indexA - 1);
                char charAtIndexB = b.charAt(indexB - 1);

                // charAtIndexA must be used to match charAtIndexB
                if (charAtIndexA == charAtIndexB) {
                    dp[indexA][indexB] = dp[indexA - 1][indexB - 1];
                }
                // can either (remove) or (capitalize to match charAtIndexB)
                else if (isEqualLowerToUpperCase(charAtIndexA, charAtIndexB)) {
                    dp[indexA][indexB] =
                        dp[indexA - 1][indexB - 1] | dp[indexA - 1][indexB];
                }
                // can only capitalize and use to match charAtIndexB
                else if (isLowercase(charAtIndexA)) {
                    dp[indexA][indexB] = dp[indexA - 1][indexB];
                }
                // none of the allowed operations can be performed
                else {
                    dp[indexA][indexB] = 0;
                }
            }
        }

        // printMatrix(dp, a, b);

        return (dp[a.length()][b.length()] == 1) ? "YES" : "NO";
    }

    static int[][] generateDp(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        dp[0][0] = 1;
        // if String a is empty, we cannot convert a to b (if b has length > 1)
        // because we can't insert characters into A to match B
        for (int indexB = 1; indexB <= b.length(); indexB++) {
            dp[0][indexB] = 0;
        }

        boolean seenUppercase = false;
        // if String b is empty, we cannot convert a to b
        // except for the lowercase prefix substring (can convert to "b" by removal)
        for (int indexA = 1; indexA <= a.length(); indexA++) {
            if (isUppercase(a.charAt(indexA - 1))) {
                seenUppercase = true;
            }
            dp[indexA][0] = seenUppercase ? 0 : 1;
        }

        return dp;
    }

    static void printMatrix(int[][] matrix, String a, String b) {
        System.out.println("=========================");
        System.out.print("      ");
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.charAt(i) + "  ");
        }
        System.out.println();

        int countB = 0;
        for (int col = 0; col <= b.length(); col++) {
            if (countB > 0) {
                System.out.print(b.charAt(countB - 1) + "  ");
            } else {
                System.out.print("   ");
            }
            for (int row = 0; row <= a.length(); row++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
            countB++;
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        System.out.println("Can be converted, daBbcd to ABC: ");
        // System.out.println(abbreviationRecursive("daBbcd", "ABC"));
        System.out.println(abbreviationDP("daBbcd", "ABC") + "\n");

        System.out.println("Can be converted, beFgH to EFH: ");
        // System.out.println(abbreviationRecursive("beFgH", "EFH"));
        System.out.println(abbreviationDP("beFgH", "EFH") + "\n");
        
        System.out.println("Can be converted, dAbCd to ABF: ");
        // System.out.println(abbreviationRecursive("dAbCd", "ABF"));
        System.out.println(abbreviationDP("dAbCd", "ABF") + "\n");

        // long before = System.nanoTime();
        //
        // System.out.println(abbreviationDP("laalsAsaasLbbabLslalBbssaAsAlSLsbBllsSalblsssbsaaaAsabBaaAaalsssasssssLbasbbllbbLSsslbabAbSlllsbsbbalbBaSaaalbslaabAAaaabsabSlsassSshBBllbAAllsSbaLblabsaLBasBsAlLaabBbAllbaslsllsaAaAabbSallbLalsslbbblbasBAsbaBLalbBssbbAlbbbsSlsllbaLBLaaLblalBSbsBbSsbbaaSlllsblbsSaaBbassslaalblBbslLlaASASbbabbLlbalSabbBbLsbaabbalsAAbSbBbABbabbabaallBsasllbsbbsslSsbBlBlbabaalblaLsllbasasalabllSsbslLbsllbLsBlaSbssSAbsSasbsSalsabbllbbaBSBlabsBlAsbaSLbSllbsAblllSLaaAlBssSsBSLslAAlsbslbalsbSbsbalbsBabSbbsssaaabassalslllbsSLSsaLlbbBslSlSbbslsbslSLbbSbAaaaalLlSlAslsbmslbbalblLabSslassBabllSAsbbsvLllSalalbsaaaLAaSSbLbblaaSbLaalABlabsAsBsalssbBLlsLssaabsslabpSbsBaBbbSBlsaaabbblslBAblsLaASlaAlbaaSssbblalAaasbaalbLlaabbAaaaaAalsabbsllaaAsallsasBbAaslbbsbllbbllbslaBASbbSblaAbbsbbssAaBbsasLllalBlslssasbssBALAasbbsbSfasabbllbAslbalbaSSlslbbSbsaBsAalablAbbaBBsbsSbdaAsBblsblbABbLAssAbalsbssSssbBBssAsABLssblsLbllSblasllLbBsassllBbBbsbBsbllsBBsAbbLLlAslBlsAAASlaalabasaLslasBLlsslsaaslsbblbAsalSlllsLSAaLlalAalsBsaslaaaalb",
        //     "ALASALABLABBASASLSBLSSLSSASBBAASSSLBBLLSSBAASLBBASBSLAAASSSSSBBLAALSALLBASBALLBBABASLLSAAAASLBBABABLABBALBSALBLLLBSSBSSAASSBBALALBBBSLLLASASLASABBBLASAASBBABAAALBLLBSSBBLBLBLLLAALLLSSSLLSLLBSSSABSSSSSBABSBLASBASSLBSLSASLAALBSBSLAASBSSBBSBBSSLLBSLSSLLBBLSLSSLBBSAALSASLSLBSABALSASLLLSLLAASSLBASBLAAABBABSBLLASASSBABBSBBBBLBABSLAASAASSSBLALAAASBLLBBAAABBLAABASSBBBLBLABASBSLAABBBSAABBASLLBSSSBBALASBSSBBASSLSBABABBBSSAABBLBABLAAABSBBSAABLSSSLSLLBALBBBBBSBBSABLLABLSAAASLABAALSABLSLBLBASASLLSALAABAAAALB"));
        // long now = System.nanoTime();
        // System.out.println("DP: Nanoseconds elapsed: " + (now-before) + " nanoseconds." );
        //
        // before = System.nanoTime();
        // System.out.println(abbreviationRecursive("laalsAsaasLbbabLslalBbssaAsAlSLsbBllsSalblsssbsaaaAsabBaaAaalsssasssssLbasbbllbbLSsslbabAbSlllsbsbbalbBaSaaalbslaabAAaaabsabSlsassSshBBllbAAllsSbaLblabsaLBasBsAlLaabBbAllbaslsllsaAaAabbSallbLalsslbbblbasBAsbaBLalbBssbbAlbbbsSlsllbaLBLaaLblalBSbsBbSsbbaaSlllsblbsSaaBbassslaalblBbslLlaASASbbabbLlbalSabbBbLsbaabbalsAAbSbBbABbabbabaallBsasllbsbbsslSsbBlBlbabaalblaLsllbasasalabllSsbslLbsllbLsBlaSbssSAbsSasbsSalsabbllbbaBSBlabsBlAsbaSLbSllbsAblllSLaaAlBssSsBSLslAAlsbslbalsbSbsbalbsBabSbbsssaaabassalslllbsSLSsaLlbbBslSlSbbslsbslSLbbSbAaaaalLlSlAslsbmslbbalblLabSslassBabllSAsbbsvLllSalalbsaaaLAaSSbLbblaaSbLaalABlabsAsBsalssbBLlsLssaabsslabpSbsBaBbbSBlsaaabbblslBAblsLaASlaAlbaaSssbblalAaasbaalbLlaabbAaaaaAalsabbsllaaAsallsasBbAaslbbsbllbbllbslaBASbbSblaAbbsbbssAaBbsasLllalBlslssasbssBALAasbbsbSfasabbllbAslbalbaSSlslbbSbsaBsAalablAbbaBBsbsSbdaAsBblsblbABbLAssAbalsbssSssbBBssAsABLssblsLbllSblasllLbBsassllBbBbsbBsbllsBBsAbbLLlAslBlsAAASlaalabasaLslasBLlsslsaaslsbblbAsalSlllsLSAaLlalAalsBsaslaaaalb",
        //     "ALASALABLABBASASLSBLSSLSSASBBAASSSLBBLLSSBAASLBBASBSLAAASSSSSBBLAALSALLBASBALLBBABASLLSAAAASLBBABABLABBALBSALBLLLBSSBSSAASSBBALALBBBSLLLASASLASABBBLASAASBBABAAALBLLBSSBBLBLBLLLAALLLSSSLLSLLBSSSABSSSSSBABSBLASBASSLBSLSASLAALBSBSLAASBSSBBSBBSSLLBSLSSLLBBLSLSSLBBSAALSASLSLBSABALSASLLLSLLAASSLBASBLAAABBABSBLLASASSBABBSBBBBLBABSLAASAASSSBLALAAASBLLBBAAABBLAABASSBBBLBLABASBSLAABBBSAABBASLLBSSSBBALASBSSBBASSLSBABABBBSSAABBLBABLAAABSBBSAABLSSSLSLLBALBBBBBSBBSABLLABLSAAASLABAALSABLSLBLBASASLLSALAABAAAALB"));
        // now = System.nanoTime();
        // System.out.println("Recursive: Nanoseconds elapsed: " + (now-before) + " nanoseconds." );
    }
}
