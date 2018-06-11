// https://www.interviewbit.com/problems/longest-substring-without-repeat/

import java.util.*;

public class LongestDistinctSubstring {
    public static int lengthOfLongestSubstring(String A) {
        int longestSubstring = 1;
        int front = 0;
        int back = 0;

        HashSet<Character> window = new HashSet<>();

        while (front < A.length()) {
            longestSubstring = Math.max(longestSubstring, front - back);

            if (window.contains(A.charAt(front))) {
                while (A.charAt(back) != A.charAt(front) && back < front) {
                    window.remove(A.charAt(back));
                    back++;
                }
                back++;
            }

            window.add(A.charAt(front));
            front++;
        }

        return Math.max(longestSubstring, front - back);
    }

    public static void main(String[] args) {
        String s = "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV";

        String s2 = "iMik7M0zSLAdEwWmWNIZNH9s5tq5XBBPkReJ7bE4YzrW2aoCxflomFGdR56ihWppWcI8G4uf6GiZDcby5kkippUtnhfIQes3tZtXnvGu6DTVf0qpAZm1mg5oBpRVIPEo2SHfvPCOV9LpBSP16eUJqZEMvhO8A9wcQxLuHcGJLp5eedZCd0r6K4ugkAtMiDwQpOmTJnGJDkf5kPeZfAbVgbqPrXHE9BC7heCu3PFG3ss1A3uoQpIGAmirlATMYWqeFh8KE9cHZ9rjQOArNVCRhzkQye6JsmIwgN33LqmKCdfc5VJmq95aulgYq4rvBqekUN7zkX9DwZRg2huLDlRtmfycepV0YV0503hB0TGJ14fs8SHfiKuzqi6Lzx1n47jl7nDybGQB8XxfQgpHn00qjaOWU6WsOlqeQftCgXnEX1vQDdJqyK5t90KcyK4LVupxv4zoSEdvlxlEzJcuBesFAqBIxkCTn9I1Wu2p55ItcAyXUuT1QzrIVFynvYvvkh5q72kBhXf8mqX6ZF0mN3uILfNuoXbI5iwdRbCx1wTHEwTKWwDnHXCQTh7sCt5PSlqhnHcyJUb1K2piBXBsVOCa0c1A09GQOs6ubIWfmuq4ZeJtmwGCFKv70W5y2HdjjHWoYMWycPLsHupk2aA6tlEQuOpGMrUW1fJBxuyQt7E9KLScvQ9qaXApddKqCj8ciZfyLPzyvUqfmKGrLDovRDFspT5ubjUMVeYZ742bAq0ELuDsXs67FyR1Kk2eULAKplkWRdNBQq1amSTcSMoW8cOWkiyv5zQ12hR2zmMDBxTTGXy8u8Tlur9dQnXu5SwAqsCpAOxkSNeRqzk7Iy05wUHnexylXyZyH2NSKu0YM5GcWxoPyS9hVayjYtWdeJ1z47w74J05xZZ4oM2l0rDgv9oQCKyhhPt3LVF6P6OGetqNcEqMRd3TQlxwyyC35d6Y6daRGlmv8zMcvHoC0aUlSM9eXQUfM5q9PFkWZLQspceuW2TuXbgeQsfhLwlBZ126oa7qNldkDmV9MgK5nqBs2n7MCnrcgsvRwI0QoYPZjOr9TWLmbImBZohHb0ks07qlchr9J5lx9bXdszPIS0zetGJ4b1O1Ad92V9r17EGS7kNwmsWNyL7R6XUN4HvJv2NQFQRide2fpX1HV2C4HDZNOj2rLVOzjAkB0IQuHts7aW8JwJbGMS9PD1RjsA7FPX1cYHpvFV5S45zkFhirRdXjBGS67GmNiNrDZaMSPMxf267eEIveFDSnqoDNAHpXFywGT9LSu2aQ6rLCZD0vDkOrIY9OBiJ13VBygWqOFx6p84wBfoQwE3UHvGOB4HiJjPxqGAA3WRCSO4fECvnKcMfy2mj1YUR2gVeMyBWUAcbTuobmpPMe7P3goNSqwC8fLUFhHrgcnlxHBhH9C1A17X9fYzZASmibYRhFlIh4LQAFwQUIDBmYzAmZ6Ql3yqmrnMEjsPdbkcjPy3hHXkehx3fp1I5dNmnvZx2ravEewm82vHOYOVnBbrsmQszujfWqzVJCepOlgNcnEdqD1D8h5pVraLvDql5jzrsFUHujVtL3qjO7p6WFe513KOfUhhmYk8KHNSPvDFrw6bXZvdNb0ZogkkSgQI3AjdmpJgzY3DSR6UmCRnehczTZJuZzEAJEVfy2AwI5JdIEmrEzWjfSfP8jTgHAJ9GKXaar1KdimLh85G9KEkFeCG8YTj0OtTvdkcH9FoN6iZEKmqp958j2TGfSKGYi8xBOQZeNdbslst363abrVBIasRzMIY948BaH9INr";

        System.out.println("Test Case 1, expecting 27: " + lengthOfLongestSubstring(s));
        System.out.println("Test Case 2, expecting 4: " + lengthOfLongestSubstring("dadbc"));
        System.out.println("Test Case 3, expecting 1: " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("Test Case 4, expecting 26: " + lengthOfLongestSubstring(s2));
    }
}
