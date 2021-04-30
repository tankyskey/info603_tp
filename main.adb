--  1  2  3  4  5  6  7  8
-- [6, 4, 7, 3, 0, 2, 8, 2]
--  i     j
--     l  k
--
--  1  2  3  4  5  6  7  8
-- [6, 4, 7, 3, 0, 2, 8, 2]
--
-- ------
-- t[k] > t[i] && l <= k
-- -> 7 > 6 && 2 < 3
-- k = k - 1 -> k = 3
--
-- l=k=2; i=1; j=3
-- t[i]=6; t[k]=4
--
--	t[i] > t[k]
-- ----
-- t[l] <= t[i] && l<=k
--   2<=6 && 2<=3
--
--  l = l+1 = 3
--
--  l>k
-- -----
--
--

procedure partition( t, i, j, k) is
	l = 1..n;
begin
	permuter(t[i], median(t[i], t[j], t[(i+j) / 2]) );
	l := i + 1; k := j;
	--1) t[i] <= t[j] && t[i] >= t[(i+j)/2)]

	while l <= k do
		while t[k] > t[i] and l <= k do
			--2) l <= k    &&    t[k] > t[i];
			-- t[i] < t[k..j]

			k := k - 1;
		end;

		while t[l] <= t[i] and l <= k do
			--3) l <= k    &&    t[l] <= t[i]
			-- t[i] >= t[i..l-1]
			l := k + 1;
		end;

		if l < k then
			permuter(t[l], t[k]);
			l := l + 1;
			k := k - 1;
		end;
		--4) l > k    ||    (t[k] <= t[i]    &&    t[l] > t[i])

	end;
	--5) t[i] >= t[k]

	permuter(t[i], t[k]);
	--6) t[i] <= t[k]

end;
