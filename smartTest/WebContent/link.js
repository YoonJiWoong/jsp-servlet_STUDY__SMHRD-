class Post {
  constructor(title, link, author, img) {
    this.title = title;
    this.link = link;
    this.author = author;
    this.img = img;
  }
}

const app = new Vue ({
  el: '#app',
  data: {
    search: '',
    postList : [
      new Post(
        '풀업', 
        'https://www.youtube.com/watch?v=nWhS28U6bCY&t=1s', 
        '바벨라토르', 
        'https://i.ytimg.com/an_webp/nWhS28U6bCY/mqdefault_6s.webp?du=3000&sqp=CMCu84sG&rs=AOn4CLDw3oIirOQHUeYEe4nJCs0SfpKxwQ'
      ),
      new Post(
        '친업', 
        'https://www.youtube.com/watch?v=6GWGVAO8oU4', 
        '핏블리',
        'https://i.ytimg.com/an_webp/6GWGVAO8oU4/mqdefault_6s.webp?du=3000&sqp=CPiE84sG&rs=AOn4CLBoBC1bhvyeEaGL_uq9PKTbpyJSSQ'
      ),
      new Post(
        '푸쉬업', 
        'https://www.youtube.com/watch?v=-_DUjHxgmWk&t=1s', 
        '바벨라토르',
        'https://i.ytimg.com/an_webp/-_DUjHxgmWk/mqdefault_6s.webp?du=3000&sqp=COSe84sG&rs=AOn4CLBVM0rSsq9v5rIyAwJp-ab9fIOhQg'
      ),
      new Post(
        '25가지 푸쉬업', 
        'https://www.youtube.com/watch?v=Npx3ygB2eRY', 
        '데스런', 
        'https://img.youtube.com/vi/Npx3ygB2eRY/0.jpg'
      ),
      new Post(
        '풀업VS친업', 
        'https://www.youtube.com/watch?v=1oIi0g363MI', 
        '피지컬갤러리', 
        'https://i.ytimg.com/an_webp/1oIi0g363MI/mqdefault_6s.webp?du=3000&sqp=CMaU84sG&rs=AOn4CLC7BZCQo-R6DpebF-_J5iUJsklpuw'
      ),
      new Post(
        '싯업', 
        'https://www.youtube.com/watch?v=tfwbpv6gCbg', 
        '지피티',
        'https://i.ytimg.com/an_webp/tfwbpv6gCbg/mqdefault_6s.webp?du=3000&sqp=CJCG84sG&rs=AOn4CLDT6mQ69kZhItH44GoVBeJsa2QGwQ'
      ),
      new Post(
        '스쿼트', 
        'https://www.youtube.com/watch?v=QyAH8O5X6g0', 
        '강경원',
        'https://i.ytimg.com/an_webp/QyAH8O5X6g0/mqdefault_6s.webp?du=3000&sqp=CISq84sG&rs=AOn4CLBpadGT3tABdy6c5SvQJz5NiJ-OnQ'
      ),
      new Post(
        '하체스트레칭', 
        'https://www.youtube.com/watch?v=UBVPNC1FBgc', 
        '피지컬갤러리', 
        'https://i.ytimg.com/an_webp/UBVPNC1FBgc/mqdefault_6s.webp?du=3000&sqp=CJ6L84sG&rs=AOn4CLBubtSRylDcjea5yv36WUH8ymhChg'
      ),
      new Post(
        '상체스트레칭', 
        'https://www.youtube.com/watch?v=FsTkLYaUh_o', 
        '피지컬갤러리',
        'https://i.ytimg.com/an_webp/FsTkLYaUh_o/mqdefault_6s.webp?du=3000&sqp=CPaz84sG&rs=AOn4CLAgPF2SOT65AmhIbJxwZ5q7_CuDaA'
      ),
      new Post(
        '플랭크', 
        'https://youtu.be/Zq8nRY9P_cM', 
        '바벨라토르',
        'https://i.ytimg.com/an_webp/Zq8nRY9P_cM/mqdefault_6s.webp?du=3000&sqp=CMKy84sG&rs=AOn4CLCY91a8E7_u5yqCpo0Q7KZrYf40WA'
      )
     
]
  },
  computed: {
    filteredList() {
      return this.postList.filter(post => {
        return post.title.toLowerCase().includes(this.search.toLowerCase())
      })
    }
  }
})