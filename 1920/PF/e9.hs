-- 64
{-}
elefantes :: Int -> IO ()
elefantes n = repete 2 n

repete :: Int -> Int -> IO ()
repete v n | (v == n) = return ()
		   | otherwise = do putStrLn ("Se " ++ show v ++" elefantes incomdam muita gente,")
		   					putStrLn (show (v+1) ++ " elefantes incomdam muito mais!")
		   					repete (v+1) n
-}
elefantes2 :: Int -> IO ()
elefantes2 n = sequence_ [putStrLn("Se "++show(v)++" elefantes incomdam muita gente, "++ show(v+1) ++ " elefantes incomdam muito mais!") | v<- [2..(n-1)]]

wc_command :: String -> IO ()
wc_command file = do {
                        str <- readFile file; --ler um ficheiro 
                        let w1 = length (lines str);
                        in let w2 = length(words str);
                        in let w3 = length str;
                        in putStr ((show w1) ++ " " ++ (show w2) ++ " " ++ (show w3) ++ " "++file);
                    }

-- 65

reverseLines :: IO ()
reverseLines = do {
                    putStrLn("Inserir string");
                    str <- getLine;
                    if(str == "Stop") then return ();
                    else do{ putStr(reverse str); reverseLines; }
                  }