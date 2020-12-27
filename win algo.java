public static int win(char[][] arr)
    {
        int p1=0;
        int p2=0;
        boolean pl1=false;
        boolean pl2=false;
        for(int i=0 ; i<6 ; i++)
        {
            if(pl1==true || pl2==true)
                break;
            p1=0;
            p2=0;
            for(int j=0 ; j<7 ; j++)
            {
                if(arr[i][j]=='r')
                {
                    p2=0;
                    p1++;
                }
                else if(arr[i][j]=='y')
                {
                    p1=0;
                    p2++;
                }
                else
                {
                    p1=0;
                    p2=0;
                }
                if(p1==4) {
                    pl1 = true;
                    break;
                }
                else if (p2==4) {
                    pl2 = true;
                    break;
                }
            }
        }
        for(int i=0 ; i<7 ; i++)
        {
            if(pl1==true || pl2==true)
                break;
            p1=0;
            p2=0;
            for(int j=0 ; j<6 ; j++)
            {
                if(arr[j][i]=='r')
                {
                    p2=0;
                    p1++;
                }
                else if(arr[j][i]=='y')
                {
                    p1=0;
                    p2++;
                }
                else
                {
                    p1=0;
                    p2=0;
                }
                if(p1==4) {
                    pl1 = true;
                    break;
                }
                else if (p2==4) {
                    pl2 = true;
                    break;
                }
            }
        }
        for(int i=3 ; i<6 ; i++)
        {
            if(pl1 || pl2)
                break;
            for(int j=0 ; i<4 ; i++)
            {
                if(pl1 || pl2)
                    break;
                p1=0;
                p2=0;
                int a=i,b=j;
                while(a>-1 && b<7)
                {
                    if(arr[a][b]=='r')
                    {
                        p2=0;
                        p1++;
                    }
                    else if(arr[a][b]=='y')
                    {
                        p1=0;
                        p2++;
                    }
                    else
                    {
                        p1=0;
                        p2=0;
                    }
                    if(p1==4) {
                        pl1 = true;
                        break;
                    }
                    else if (p2==4) {
                        pl2 = true;
                        break;
                    }
                    a--;
                    b++;
                }
            }
        }
        for(int i=3 ; i<6 ; i++)
        {
            if(pl1 || pl2)
                break;
            for(int j=6 ; i>=3 ; i--)
            {
                if(pl1 || pl2)
                    break;
                p1=0;
                p2=0;
                int a=i,b=j;
                while(a>-1 && b>-1)
                {
                    if(arr[a][b]=='r')
                    {
                        p2=0;
                        p1++;
                    }
                    else if(arr[a][b]=='y')
                    {
                        p1=0;
                        p2++;
                    }
                    else
                    {
                        p1=0;
                        p2=0;
                    }
                    if(p1==4) {
                        pl1 = true;
                        break;
                    }
                    else if (p2==4) {
                        pl2 = true;
                        break;
                    }
                    a--;
                    b--;
                }
            }
        }
            if(pl1==true)
                return 1;
            else if(pl2==true)
                return -1;
            else
                return 2;
    }