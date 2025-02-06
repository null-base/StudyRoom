#include <stdio.h>
#include <stdlib.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define MAX(a, b) ((a) > (b) ? (a) : (b))

// A: 2次元配列, N: 行数, M: 列数
int solution(int **A, int N, int M)
{
  int dpTopLeft[N + 1][M + 1], dpBottomRight[N + 1][M + 1];
  int maxSquareSizeTopLeft = 0, maxSquareSizeBottomRight = 0;

  // 初期化
  for (int i = 0; i <= N; i++)
    for (int j = 0; j <= M; j++)
      dpTopLeft[i][j] = dpBottomRight[i][j] = 0;

  // 左上から右下へのスキャン
  for (int i = 1; i <= N; i++)
  {
    for (int j = 1; j <= M; j++)
    {
      if (A[i - 1][j - 1] == 1)
      {
        dpTopLeft[i][j] = MIN(MIN(dpTopLeft[i][j - 1], dpTopLeft[i - 1][j]), dpTopLeft[i - 1][j - 1]) + 1;
        maxSquareSizeTopLeft = MAX(maxSquareSizeTopLeft, dpTopLeft[i][j]);
      }
    }
  }

  // 右下から左上へのスキャン
  for (int i = N; i >= 1; i--)
  {
    for (int j = M; j >= 1; j--)
    {
      if (A[i - 1][j - 1] == 1)
      {
        dpBottomRight[i][j] = MIN(MIN(dpBottomRight[i][j + 1], dpBottomRight[i + 1][j]), dpBottomRight[i + 1][j + 1]) + 1;
        if (dpBottomRight[i][j] < maxSquareSizeTopLeft)
          maxSquareSizeBottomRight = MAX(maxSquareSizeBottomRight, dpBottomRight[i][j]);
      }
    }
  }

  // 最大正方形の面積を返す
  return maxSquareSizeBottomRight * maxSquareSizeBottomRight;
}
