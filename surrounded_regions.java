/*
 *Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .
 *
 * */



class Solution {
public:
    void solve(vector<vector<char>> &board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (board.size() < 3 || board[0].size() < 3) 
            return;
        int m = board.size(), n = board[0].size();
        unordered_set<int> visited;
        stack<int> to_visit;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ( board[i][j] == 'O' && (i == 0 || i == m-1 || j == 0 || j == n-1)) {
                    to_visit.push(i * n + j);
                }
            }
        }
        while (!to_visit.empty()) {
            int temp = to_visit.top();
            to_visit.pop();
            int x = temp/n, y = temp%n;
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    if (i * j == 0 && i+j != 0 &&
                        x+i > 0 && x+i < m-1 && y+j > 0 && y+j < n-1 &&
                        board[x+i][y+j] == 'O' &&
                        visited.find((x+i) * n +y+j) == visited.end()) {
                        to_visit.push((x+i) * n +y+j);
                        visited.insert((x+i) * n +y+j);
                    }
                }
            }
        }
        
        for (int i = 1; i < m-1; ++i) {
            for (int j = 1; j < n-1; ++j) {
                if ( board[i][j] == 'O' && visited.find(i * n + j) == visited.end()) {
                  board[i][j] = 'X';
                }
            }
        }
    }
};
